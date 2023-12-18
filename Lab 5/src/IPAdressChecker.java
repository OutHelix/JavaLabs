import java.util.regex.*;

public class IPAdressChecker {
    public static void main(String[] args) {
        String ipAdress = "255.168.0.21";
        Pattern pattern = Pattern.compile("^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$");
        Matcher matcher = pattern.matcher(ipAdress);
        if (matcher.matches()) {
            System.out.println("Valid IP Adress!");
        } else {
            System.out.println("Invalid IP Adress!");
        }
    }
} // -- 4 --
