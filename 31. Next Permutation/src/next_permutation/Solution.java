package next_permutation;

public class Solution {
    public void nextPermutation(int[] nums) {
        int length = nums.length;
        int i, j, end = length - 1;
        for (i = length-1; i > 0; i --) {
            if (nums[i-1] < nums[i]) break;
        }
        if (i > 0) {
            for (j = i + 1; j < length; j ++) {
                if (nums[j] <= nums[i-1]) break;
            }
            int temp = nums[j-1];
            nums[j-1] = nums[i-1];
            nums[i-1] = temp;
        }
        while (i < end) {
            int temp = nums[i];
            nums[i] = nums[end];
            nums[end] = temp;
            i ++; end --;
        }
    }
}
