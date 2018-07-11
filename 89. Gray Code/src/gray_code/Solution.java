package gray_code;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> grayCode(int n) {
        
        List<Integer> result = new ArrayList<Integer>();
        result.add(0);
        if (n <= 0) return result;
        
        int[] exp2 = new int[n];
        boolean[] pos_neg = new boolean[n];
        exp2[0] = 1;
        for (int i = 1; i < n; i ++) { exp2[i] = 2 * exp2[i - 1]; }
        
        int currentNum = 0, currentIndex = 0; 
        while(++ currentIndex < 1 << n) {
            int dividerIndex = n - 1;
            while (dividerIndex >= 0) {
                int divider = exp2[dividerIndex];
                if (currentIndex % divider == 0) {
                    if (!pos_neg[dividerIndex]) { currentNum += divider; } else { currentNum -= divider; }
                    result.add(currentNum);
                    pos_neg[dividerIndex] = !pos_neg[dividerIndex];
                    break;
                }
                dividerIndex --;
            }
        }
        return result;
    }
}
