import java.util.*;
import java.util.stream.*;

public class DataProcessors {

    @DataProcessor(comment = "Удаляем из входного списка пустые строки или строки из пробелов")
    public static List<String> filterData(List<String> data) {
        return data.stream()
            .filter(line -> !line.trim().isEmpty())
            .collect(Collectors.toList());
    }

    @DataProcessor(comment = "Преобразуем все строки из входного списка в верхний регистр")
    public static List<String> transformData(List<String> data) {
        return data.stream()
            .map(String::toUpperCase)
            .collect(Collectors.toList());
    }

    @DataProcessor(comment = "// объединяем все строки во входном списке в одну строку разделённую запятыми и пробелами")
    public static List<String> aggregateData(List<String> data) {
        String aggregated = data.stream().collect(Collectors.joining(", "));
        return List.of(aggregated);
    } 
}