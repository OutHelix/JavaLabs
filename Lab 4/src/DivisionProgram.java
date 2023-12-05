import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DivisionProgram {
    public static void main(String[] args) {
        int numerator = 10;
        int denominator = 0;

        try {
            double result = divideNumbers(numerator, denominator);
            System.out.println("Answer: " + result);
        } catch (CustomDivisionException e) {
            System.out.println("Error: " + e.getMessage());
            logException(e);
        }
    }

    // Метод для деления чисел с возможным исключением CustomDivisionException
    public static double divideNumbers(int numerator, int denominator) throws CustomDivisionException {
        if (denominator == 0) {
            throw new CustomDivisionException("Division by zero is not allowed.");
        }
        return (double) numerator / denominator;
    }

    // Метод для логирования исключения в файл
    public static void logException(Exception e) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("exception_log.txt", true))) {
            LocalDateTime currentTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedTime = currentTime.format(formatter);
            writer.write("[" + formattedTime + "] Exception occurred: " + e.getClass().getName() + " - " + e.getMessage() + "\n");
        } catch (IOException ex) {
            System.out.println("The error writing to the exception log file: " + ex.getMessage());
        }
    }
}
