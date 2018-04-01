package permutation_sequence;

import java.util.LinkedList;

class Solution {
    public String getPermutation(int n, int k) {
        
        LinkedList<Integer> numbers = new LinkedList<Integer>();
        for (int j = 1; j <= n; j ++) { numbers.add(j); }
        String result = "";
        k --;
        
        for (int i = n - 1; i >= 0; i --) {
            int order = k / getFactorial(i);
            k = k % getFactorial(i);
            result += numbers.remove(order);
        }
        
        return result;
    }
    private int getFactorial(int n) {
        int result = 1;
        for (int i = 2; i <= n; i ++) {
            result *= i;
        }
        return result;
    }
}
