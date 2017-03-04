package regular_expression_matching;

public class Solution_Edition1 {
    public boolean isMatch(String s, String p) {
        return Match(s, p);
    }
    
    public boolean Match(String s, String p) {
        if (p.length() < 2) {
            if ((s.length() == p.length()) && (s.equals(p) || (p.charAt(0) == '.'))) {
                return true;
            }
            return false;
        } else {
            if (p.charAt(1) == '*') {
                boolean flag = false;
                int index = -1;
                while ((index < s.length()) && ((index < 0) || (p.charAt(0) == '.') || (s.charAt(index) == p.charAt(0)))) {
                    flag = (flag || Match(s.substring(index + 1), p.substring(2)));
                    index ++;
                }
                return flag;
            } else {
                if ((s.length() != 0) && ((p.charAt(0) == '.') || (s.charAt(0) == p.charAt(0)))) {
                    return Match(s.substring(1), p.substring(1));
                }
                return false;
            }
        }
    }
}