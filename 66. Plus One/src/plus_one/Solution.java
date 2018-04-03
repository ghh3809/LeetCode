package plus_one;

class Solution {
    public int[] plusOne(int[] digits) {
        if (digits.length == 0) return digits;
        boolean addFlag = false;
        digits[digits.length - 1] ++;
        for (int i = digits.length - 1; i >= 0; i --) {
            if (addFlag) {
                digits[i] ++;
                addFlag = false;
            }
            if (digits[i] >= 10) {
                digits[i] -= 10;
                addFlag = true;
            }
        }
        if (addFlag) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            for (int i = 0; i < digits.length; i ++) {
                newDigits[i + 1] = digits[i];
            }
            return newDigits;
        } else {
            return digits;
        }
    }
}
