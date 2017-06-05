package maximum_subarray;

public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        int min = 0, max = 0, sum = 0, i = 0, result = nums[0];
        while ((i < nums.length) && (nums[i] <= 0)) {
            result = nums[i] > result ? nums[i] : result;
            i ++;
        }
        if (i >= nums.length) return result;
        for (; i < nums.length; i ++) {
            sum += nums[i];
            if (sum > max) max = sum;
            else if (sum < min) {
                result = max - min > result ? max - min : result;
                min = sum;
                max = sum;
            }
        }
        return max - min > result ? max - min : result;
    }
}
