package remove_duplicates_from_sorted_array_ii;

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;
        int index = 1, left = 2;
        while(++ index < nums.length) {
            if (nums[index] != nums[left - 2]) {
                int temp = nums[index];
                nums[index] = nums[left];
                nums[left ++] = temp;
            }
        }
        return left;
    }
}
