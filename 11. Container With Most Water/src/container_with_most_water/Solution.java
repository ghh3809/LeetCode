package container_with_most_water;

public class Solution {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int max = 0;
        while (i != j) {
            int temp = Math.min(height[i], height[j]) * (j - i);
            if (temp > max) max = temp;
            if (height[i] > height[j]) {
                j --;
            } else {
                i ++;
            }
        }
        return max;
    }
}
