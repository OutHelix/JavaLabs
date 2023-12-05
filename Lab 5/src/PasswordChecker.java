import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordChecker { // -- 2
    public static void main(String[] args) {
        String password = "Abcdefg1";
        Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,16}$");
        Matcher matcher = pattern.matcher(password);
        if (matcher.matches()) {
            System.out.println("Valid password!");
        } else {
            System.out.println("Invalid password!");
        }
    }
}
