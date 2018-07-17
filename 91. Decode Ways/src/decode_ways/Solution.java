package decode_ways;

class Solution {
    public int numDecodings(String s) {
        int countLast = 1, countNow = 1;
        if (s.charAt(0) == '0') return 0;
        for (int i = 1; i < s.length(); i ++) {
            char cLast = s.charAt(i - 1), c = s.charAt(i);
            int countNext = 0;
            if (c != '0') {
                countNext += countNow;
            }
            if ((cLast > '0') && (10 * (cLast - '0') + (c - '0') <= 26)) {
                countNext += countLast;
            }
            if (countNext == 0) return 0;
            countLast = countNow;
            countNow = countNext;
        }
        return countNow;
    }
}
