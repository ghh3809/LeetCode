package count_and_say;

public class Solution {
    public String countAndSay(int n) {
        if (n < 1) return "";
        String s = "1";
        for (int i = 1; i < n; i ++) {
            s = say(s);
        }
        return s;
    }
    private String say(String s) {
        StringBuilder news = new StringBuilder();
        char lastc = s.charAt(0);
        int lastIndex = 0;
        for (int i = 1; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (c != lastc) {
                news.append(String.valueOf(i - lastIndex));
                news.append(lastc);
                lastc = c;
                lastIndex = i;
            }
        }
        news.append(String.valueOf(s.length() - lastIndex));
        news.append(lastc);
        return news.toString();
    }
}