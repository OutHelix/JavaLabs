import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        List<String> inputData = List.of("text", "123123","" , " ", "date");
        java.nio.file.Files.write(java.nio.file.Paths.get("C:\\Users\\OutHelix\\Desktop\\JavaLabs\\Lab 8\\src\\input.txt"), inputData);

        // Создаем объект DataManager, который будет управлять обработкой данных.
        DataManager dataManager = new DataManager();
        //регистрируем обработчик класса
        dataManager.registerDataProcessor(new DataProcessors());

        // загружаем в экземпляр класса данные
        dataManager.loadData("C:\\Users\\OutHelix\\Desktop\\JavaLabs\\Lab 8\\src\\input.txt");

        //обрабатываем
        dataManager.processData();

        //сохраняем
        dataManager.saveData("C:\\Users\\OutHelix\\Desktop\\JavaLabs\\Lab 8\\src\\output.txt");
    }
}