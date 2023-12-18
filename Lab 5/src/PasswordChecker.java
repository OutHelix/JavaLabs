import java.util.regex.*;

public class PasswordChecker {
    public static void main(String[] args) {
        String password = "lala23psdd";
        Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,16}$");
        Matcher matcher = pattern.matcher(password);

        if (matcher.matches()) {
            System.out.println("Valid password");
        } else {
            System.out.println("Не верно! Пароль должен содержать от 8 до 16 символов, хотя бы одну цифру, хотя бы одну заглавную и хотя бы одну строчную букву.");
        }
    }
} // -- 2 --
