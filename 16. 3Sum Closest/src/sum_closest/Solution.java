package sum_closest;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        int lasti = nums[0] - 1;
        for (int i = 0; i < nums.length - 2; i ++) {
            if (nums[i] == lasti) continue;
            if ((i > 0) && (nums[i-1] > target / 3)) break;
            lasti = nums[i];
            int start = i + 1, end = nums.length - 1;
            int lastStartNum = nums[start] - 1;
            int lastEndNum = nums[end] + 1;
            while (start < end) {
                if (nums[start] == lastStartNum) {
                    start ++;
                    continue;
                }
                if (nums[end] == lastEndNum) {
                    end --;
                    continue;
                }
                int sum = nums[i] + nums[start] + nums[end];
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
                if (sum > target) {
                    lastEndNum = nums[end];
                    end --;
                } else if (sum < target) {
                    lastStartNum = nums[start];
                    start ++;
                } else {
                    return target;
                }
            }
        }
        return result;
    }
}
