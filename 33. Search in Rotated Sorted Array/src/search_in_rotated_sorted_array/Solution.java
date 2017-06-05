package search_in_rotated_sorted_array;

public class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int lo = 0, hi = nums.length;
        boolean flag = (target >= nums[0]);
        while (lo < hi) {
            int mi = (lo + hi) / 2;
            if (flag) { if ((nums[mi] >= nums[0]) && (nums[mi] <= target)) lo = mi + 1; else hi = mi; }
            else { if ((nums[mi] <= nums[nums.length-1]) && (nums[mi] > target)) hi = mi; else lo = mi + 1; }
        }
        if ((lo > 0) && (nums[--lo] == target)) return lo; else return -1;
    }
}
