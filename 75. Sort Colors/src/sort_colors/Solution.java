package sort_colors;

class Solution {
    public void sortColors(int[] nums) {
        int left = 0, mid = 0, right = nums.length - 1;
        while (mid <= right) {
            if (nums[mid] == 0) {
                nums[mid ++] = 1;
                nums[left ++] = 0;
            } else if (nums[mid] == 1) {
                mid ++;
            } else {
                nums[mid] = nums[right];
                nums[right --] = 2;
            }
        }
    }
}
