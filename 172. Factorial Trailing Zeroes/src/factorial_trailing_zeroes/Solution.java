package factorial_trailing_zeroes;

public class Solution {
    public int trailingZeroes(int n) {
        long five = 5;
        int count = 0;
        while (five <= n) {
            count += n / five;
            five *= 5;
        }
        return count;
    }
}
