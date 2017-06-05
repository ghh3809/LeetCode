package search_for_a_range;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
        int lo = 0, hi = nums.length, left = -1, right = 0;
        
        //方法1
        while (lo < hi) {
            int mi = (lo + hi) / 2;
            if (nums[mi] > target) {
                hi = mi;
            } else if (nums[mi] < target) {
                lo = mi + 1;
            } else {
                left = leftSearch(nums, lo, mi, target);
                right = rightSearch(nums, mi, hi, target);
                break;
            }
        }
        return new int[]{left, right-1};
        
        // 方法2
        // left = leftSearch(nums, lo, hi, target);
        // right = rightSearch(nums, lo, hi, target);
        // if ((left >= nums.length) || (nums[left] != target)) return new int[]{-1, -1}; else return new int[]{left, right-1};
        
    }
    public int leftSearch(int[] nums, int lo, int hi, int target) {
        while (lo < hi) {
            int mi = (lo + hi) / 2;
            if (nums[mi] >= target) hi = mi; else lo = mi + 1;
        }
        return hi;
    }
    public int rightSearch(int[] nums, int lo, int hi, int target) {
        while (lo < hi) {
            int mi = (lo + hi) / 2;
            if (nums[mi] <= target) lo = mi + 1; else hi = mi;
        }
        return lo;
    }
}
