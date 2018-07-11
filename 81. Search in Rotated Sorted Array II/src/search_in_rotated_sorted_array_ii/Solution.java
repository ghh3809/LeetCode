package search_in_rotated_sorted_array_ii;

class Solution {
    public boolean search(int[] nums, int target) {
        
        if (nums.length == 0) return false;
        int lo = 0, hi = nums.length;
        // For the situation two sides are equal, it is hard to decide the pivot;
        // So just search until different values appear.
        while ((lo < hi) && (nums[lo] == nums[hi - 1])) {
            if ((nums[lo ++] == target) || (nums[-- hi] == target)) return true;
        }
        if (lo >= hi) return false;
        // Find different value, substitude two side values
        nums[0] = nums[lo]; nums[nums.length - 1] = nums[hi - 1];
        
        // There are two situations, one is at left and the other is at right
        if (nums[lo] <= target) {
            while (lo < hi) {
                int mi = (lo + hi) / 2;
                // If mi is in wrong side
                if (nums[mi] < nums[0]) {
                    hi = mi;
                    continue;
                } else {
                    if (nums[mi] <= target) lo = mi + 1;
                    else hi = mi;
                }
            }
            if (lo == 0) return false;
            if (nums[--lo] == target) return true;
            
        } else if (target <= nums[hi - 1]) {
            while (lo < hi) {
                int mi = (lo + hi) / 2;
                if (nums[mi] > nums[nums.length - 1]) {
                    lo = mi + 1;
                    continue;
                } else {
                    if (nums[mi] <= target) lo = mi + 1;
                    else hi = mi;
                }
            }
            if (lo == 0) return false;
            if (nums[--lo] == target) return true;
        }
        
        return false;
    }
}
