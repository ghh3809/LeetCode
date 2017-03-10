package sum;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) return result;
        Arrays.sort(nums);
        int lasti = nums[0] - 1;
        for (int i = 0; i < nums.length - 2; i ++) {
            if (nums[i] == lasti) continue;
            if (nums[i] > 0) break;
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
                if (sum > 0) {
                    lastEndNum = nums[end];
                    end --;
                } else if (sum < 0) {
                    lastStartNum = nums[start];
                    start ++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    lastEndNum = nums[end];
                    lastStartNum = nums[start];
                    start ++;
                    end --;
                }
            }
        }
        return result;
    }
}
