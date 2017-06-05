package sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 4) return result;
        Arrays.sort(nums);
        int lastj = nums[0] - 1;
        for (int j = 0; j < nums.length - 3; j ++) {
            if (nums[j] == lastj) continue;
            if (nums[j] > target / 4) break;
            lastj = nums[j];
            int lasti = nums[j + 1] - 1;
            for (int i = j + 1; i < nums.length - 2; i ++) {
                if (nums[i] == lasti) continue;
                if (nums[j] + nums[i] > target / 2) break;
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
                    int sum = nums[j] + nums[i] + nums[start] + nums[end];
                    if (sum > target) {
                        lastEndNum = nums[end];
                        end --;
                    } else if (sum < target) {
                        lastStartNum = nums[start];
                        start ++;
                    } else {
                        result.add(Arrays.asList(nums[j], nums[i], nums[start], nums[end]));
                        lastEndNum = nums[end];
                        lastStartNum = nums[start];
                        start ++;
                        end --;
                    }
                }
            }
        }
        return result;
    }
}
