package reverse_integer;

public class Solution {
    private int INT_MAX = (1<<31) - 1;
    private int INT_MIN = 1<<31;
    public int reverse(int x) {
        long result = 0;
        while (x != 0) {
            int temp = x % 10;
            x = x / 10;
            if ((result * 10 + temp > INT_MAX) || (result * 10 + temp < INT_MIN)) {
                return 0;
            }
            result = result * 10 + temp;
        }
        return (int)result;
    }
}
