package longest_palindromic_substring;

public class Solution {
    private int startPosi, endPosi, maxLength = 0;
    public String longestPalindrome(String s) {
        int length = s.length();
        if (length < 2) {
            return s;
        }
        for (int i = 0; i < length - 1; i ++) {
            getMaxLength(s, i, i);
            getMaxLength(s, i, i + 1);
        }
        return s.substring(startPosi, endPosi + 1);
    }
    
    public void getMaxLength(String s, int stp, int edp) {
        while ((stp >= 0) && (edp < s.length())) {
            if (s.charAt(stp) == s.charAt(edp)) {
                if (edp - stp + 1> maxLength) {
                    startPosi = stp;
                    endPosi = edp;
                    maxLength = edp - stp + 1;
                }
                stp --;
                edp ++;
            } else {
                break;
            }
        }
    }
}
