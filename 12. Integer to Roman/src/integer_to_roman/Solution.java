package integer_to_roman;

public class Solution {
    public String intToRoman(int num) {
        StringBuilder s = new StringBuilder();
        int[] nums = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] ss = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int index = 0;
        while (num > 0) {
            if (num >= nums[index]) {
                s.append(ss[index]);
                num -= nums[index];
            } else {
                index ++;
            }
        }
        return s.toString();
    }
}
