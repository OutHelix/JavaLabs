import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;
import java.io.*;
import java.nio.file.*;
import java.lang.reflect.*;

public class DataManager {
    private List<String> data = new ArrayList<>();
    private List<Method> processors = new ArrayList<>();


    //Метод регистрирует переданный объект как обработчик данных,
    //добавляя все методы этого объекта, помеченные аннотацией @DataProcessor, в список processors
    public void registerDataProcessor(Object processor) {
        for (Method method : processor.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(DataProcessor.class)) {
                processors.add(method);
            }
        }
    }

    //читаем данные из файла и возвращаем их в виде потока строк
    public void loadData(String source) throws IOException {
        data = Files.readAllLines(Paths.get(source));
    }


    public void processData() {
        // создаем с фиксированным числом потоков, равным кол-ву зарегистрированных обработчиков
        ExecutorService executor = Executors.newFixedThreadPool(processors.size());

        List<Future<String>> futures = processors.stream()
                .map(method -> executor.submit(() -> {
                    try {
                        // Вызов метода-обработчика для каждого элемента списка данных data
                        Object result = method.invoke(null, data);
                        // результат вызова метода типом List - ?
                        if (result instanceof List<?>) {
                            List<?> resultList = (List<?>) result; // приводим результат метода к типу лист
                            if (resultList.stream().allMatch(item -> item instanceof String)) { // все ли String в листе
                                List<String> processedData = resultList.stream()
                                        .map(String::valueOf) // каждый элемент преобразовывает в строковое представление
                                        .collect(Collectors.toList());
                                String comment = method.getAnnotation(DataProcessor.class).comment();
                                return comment + "\n" + processedData.toString() + "\n";
                            } else {
                                return "Error: Список содержит элементы, которые не являются строковыми.\n";
                            }
                        } else {
                            return "Error: Метод не вернул List<String>.\n";
                        }
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                        return "";
                    }
                }))
                .collect(Collectors.toList());

        data = futures.stream().flatMap(future -> {
            try {
                // ожидаем завершения выполнения каждого метода-обработчика
                return Stream.of(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
            return Stream.empty();
        }).collect(Collectors.toList());

        executor.shutdown();
    }

    //для сохранения данных в файл
    public void saveData(String destination) throws IOException {
        Files.write(Paths.get(destination), data);
    }
}
