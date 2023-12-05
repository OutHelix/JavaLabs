import java.util.regex.*;

public class WordStartingWithLetter { // -- 5
    public static void main(String[] args) {
        String text = "Java is a programming language and JavaScript is used for web development";
        char startingLetter = 'J';
        Pattern pattern = Pattern.compile("\\b" + startingLetter + "\\w*\\b", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}