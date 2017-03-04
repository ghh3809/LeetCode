package regular_expression_matching;

public class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] match = new boolean[s.length() + 1][p.length() + 1];
        match[0][0] = true;
        for (int j = 2; j <= p.length(); j = j + 2) {
            if ((match[0][j-2]) && (p.charAt(j-1) == '*')) {
                match[0][j] = true;
            } else {
                break;
            }
        }
        if ((s.length() > 0) && (p.length() > 0) && ((p.charAt(0) == '.') || (s.charAt(0) == p.charAt(0)))) {
            match[1][1] = true;
        }
        for (int i = 1; i <= s.length(); i ++) {
            for (int j = 2; j <= p.length(); j ++) {
                if (p.charAt(j-1) == '*') {
                    match[i][j] = match[i][j-2] || match[i][j-1] || (((s.charAt(i-1) == p.charAt(j-2)) || (p.charAt(j-2) == '.')) && match[i-1][j]);
                } else if ((s.charAt(i-1) == p.charAt(j-1)) || (p.charAt(j-1) == '.')) {
                    match[i][j] = match[i-1][j-1];
                }
            }
        }
        return match[s.length()][p.length()];
    }
}