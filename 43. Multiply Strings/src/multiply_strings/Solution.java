package multiply_strings;

public class Solution {
    public String multiply(String num1, String num2) {
        int l1 = num1.length(), l2 = num2.length();
        if ((l1 == 1) && (num1.charAt(0) == '0')) return "0";
        if ((l2 == 1) && (num2.charAt(0) == '0')) return "0";
        int[][] table = new int[l2][l1];
        char[] result = new char[l1+l2];
        result[0] = '0';
        for (int i = 0; i < l2; i ++) {
            for (int j = 0; j < l1; j ++) {
                table[i][j] = (num2.charAt(i) - '0') * (num1.charAt(j) - '0');
            }
        }
        int upgrade = 0;
        for (int line = l1 + l2 - 2; line >= 0; line --) {
            int i = line >= l1 ? line - l1 + 1 : 0;
            int j = line < l1 ? line : l1 - 1;
            int sum = 0;
            while ((i < l2) && (j >= 0)) {
                sum += table[i][j];
                i ++; j --;
            }
            int digit = (sum + upgrade) % 10;
            upgrade = (sum + upgrade) / 10;
            result[line+1] = (char) (digit + '0');
        }
        if (upgrade > 0) { result[0] = (char) (upgrade + '0'); return String.valueOf(result); }
        else { return String.valueOf(result).substring(1); }
    }
}
