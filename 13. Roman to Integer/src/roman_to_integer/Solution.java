package roman_to_integer;

public class Solution {
    public int romanToInt(String s) {
        int length = s.length();
        int result = 0;
        int[] num = new int[length];
        boolean[] flag = new boolean[length];
        for (int i = 0; i < length; i ++) {
            num[i] = charToInt(s.charAt(i));
            if ((i > 0) && (num[i] > num[i-1])) {
                flag[i-1] = true;
            }
        }
        for (int i = 0; i < length; i ++) {
            if (flag[i]) {
                result -= num[i];
            } else {
                result += num[i];
            }
        }
        return result;
    }
    public int charToInt(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return 0;
    }
}