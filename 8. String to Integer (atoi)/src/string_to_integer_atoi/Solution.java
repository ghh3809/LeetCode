package string_to_integer_atoi;

public class Solution {
    public int myAtoi(String str) {
        int INT_MAX = (1 << 31) - 1;
        int INT_MIN = 1 << 31;
        boolean flag = true;
        int i;
        long result = 0;
        for (i = 0; i < str.length(); i ++) {
            char c = str.charAt(i);
            if (c == ' ') {
                continue;
            } else if (c == '+') {
                i = i + 1;
                break;
            } else if (c == '-') {
                i = i + 1;
                flag = false;
                break;
            } else if ((c <= '9') && (c >= '0')) {
                break;
            } else {
                return 0;
            }
        }
        for (; i < str.length(); i ++) {
            char c = str.charAt(i);
            if ((c <= '9') && (c >= '0')) {
                result = result * 10 + (c - '0');
                if ((flag) && (result > INT_MAX)) {
                    return INT_MAX;
                } else if ((!flag) && (-result < INT_MIN)) {
                    return INT_MIN;
                }
            } else {
                break;
            }
        }
        if (flag) {
            return (int)result;
        } else {
            return -(int)result;
        }
    }
}
