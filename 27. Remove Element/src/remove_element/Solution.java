package remove_element;

public class Solution {
    public int removeElement(int[] nums, int val) {
        int start = 0, end = nums.length - 1, temp;
        while (end >= start) {
            while ((end > -1) && (nums[end] == val)) {
                end --;
            }
            while ((start < nums.length) && (nums[start] != val)) {
                start ++;
            }
            if (end > start) {temp = nums[start];  nums[start] = nums[end];  nums[end] = temp;}
        }
        return start;
    }
}
