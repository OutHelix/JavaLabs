import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPAddressChecker { // -- 4
    public static void main(String[] args) {
        String ipAddress = "192.168.0.1";
        Pattern pattern = Pattern.compile("^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$");
        Matcher matcher = pattern.matcher(ipAddress);
        if (matcher.matches()) {
            System.out.println("Valid IP Address!");
        } else {
            System.out.println("Invalid IP Address!");
        }
    }
}