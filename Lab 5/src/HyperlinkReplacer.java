public class HyperlinkReplacer { // -- 3
    public static void main(String[] args) {
        String text = "Visit my website at http://www.example.com and also check https://www.anotherexample.com";
        String replacedText = text.replaceAll("\\b(?:https?|ftp):\\/\\/[-A-Z0-9+&@#\\/%?=~_|!:,.;]*[-A-Z0-9+&@#\\/%=~_|]", "<a href=\"$0\">$0</a>");
        System.out.println(replacedText);
    }
}

