package divide_two_integers;

public class Solution {
    public int divide(int _dividend, int _divisor) {
        
        //Pre-condition
        boolean flag = true;
        long count = 0;
        long dividend = _dividend;
        long divisor = _divisor;
        if (dividend < 0) {
            dividend = - dividend;
            flag = !flag;
        }
        if (divisor < 0) {
            divisor = - divisor;
            flag = !flag;
        } else if (divisor == 0) return (1 << 31) - 1;
        
        //generate arrays
        long[] arr = new long[32];
        int[] result = new int[32];
        arr[0] = divisor;
        result[0] = 1;
        int i;
        for (i = 0; i < 31; i ++) {
            if ((arr[i] > 0) && (dividend >= arr[i])) {
                dividend -= arr[i];
                count += result[i];
            } else {
                break;
            }
            arr[i+1] = arr[i] + arr[i];
            result[i+1] = result[i] + result[i];
        }
        
        //back track
        i --;
        while ((dividend != 0) && (i >= 0)) {
            if (dividend >= arr[i]) {
                dividend -= arr[i];
                count += result[i];
            }
            i --;
        }
        
        //output
        if (!flag) count = - count;
        if ((count > (1 << 31) - 1) || (count < (1 << 31))) return (1 << 31) - 1;
        return (int)count;
    }
}
