package remove_duplicates_from_sorted_array;

public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int newLine = 1, last = nums[0], temp;
        for (int i = 1; i < nums.length; i ++) {
            temp = nums[i];
            if (temp != last) {
                nums[newLine] = temp;
                newLine ++;
                last = temp;
            }
        }
        return newLine;
    }
}
