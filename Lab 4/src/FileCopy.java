import java.io.*;
import java.util.Arrays;

public class FileCopy {
    public static void main(String[] args) {
        String sourceFile = "Lab 4/source.txt"; // Имя исходного файла
        String destinationFile = "Lab 4/destination.txt"; // Имя файла, в который будет копироваться содержимое

        try (FileInputStream inputStream = new FileInputStream(sourceFile);
             FileOutputStream outputStream = new FileOutputStream(destinationFile)) {

            byte[] buffer = new byte[1024];
            int length;

            // Чтение данных из исходного файла в буфер и запись в целевой файл
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
                System.out.println(length);
            }

            System.out.println("Содержимое файла скопировано успешно.");
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка: файл не найден");
        } catch (IOException e) {
            System.out.println("Ошибка при копировании содержимого файла: " + e.getMessage());
        }
    }
}
