package search_insert_position;

public class Solution {
    public int searchInsert(int[] nums, int target) {
        int lo = 0, hi = nums.length;
        while (lo < hi) {
            int mi = (lo + hi) / 2;
            if (nums[mi] <= target) lo = mi + 1; else hi = mi;
        }
        lo --;
        if ((lo >= 0) && (nums[lo] == target)) return lo;
        else return lo + 1;
    }
}
