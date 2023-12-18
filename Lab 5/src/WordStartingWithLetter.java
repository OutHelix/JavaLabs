import java.util.regex.*;

public class WordStartingWithLetter {
    public static void main(String[] args) {
        String text = "Java is a programming language and JavaScript is used for web development";
        char startingLetter = 'g';

        if (!Character.isLetter(startingLetter)) {
            System.out.println("Некорректная начальная буква.");
        } else {
            Pattern pattern = Pattern.compile("\\b" + startingLetter + "\\w*\\b", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(text);
            boolean wordFound = false; // Флаг для отслеживания наличия слов, начинающихся с указанной буквы

            while (matcher.find()) {
                wordFound = true;
                System.out.println(matcher.group());
            }

            if (!wordFound) {
                System.out.println("Слова, начинающегося с буквы '" + startingLetter + "', не найдены.");
            }
        }
    }
}

