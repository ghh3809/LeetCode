package powx_n;

public class Solution {
    public double myPow(double x, int n) {
        boolean flag = false;
        long nn = n;
        if (n < 0) {
            flag = true;
            nn = -nn;
        }
        double result = 1;
        double[] power = new double[32];
        power[0] = x;
        int i = 1;
        for (; i < 32; i ++) {
            if (nn >= ((long)1<<i)) {
                power[i] = power[i-1] * power[i-1];
            } else {
                break;
            }
        }
        i --;
        while (nn > 0) {
            if (((long)1<<i) <= nn) {
                result *= power[i];
                nn -= ((long)1<<i);
            }
            i --;
        }
        if (flag) return 1/result; else return result;
    }
}
