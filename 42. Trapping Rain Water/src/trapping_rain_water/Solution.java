package trapping_rain_water;

public class Solution {
    public int trap(int[] height) {
        if (height.length <= 2) return 0;
    	int area = 0;
    	int lo = 0, hi = height.length - 1;
    	int leftMax = height[lo], rightMax = height[hi];
    	while (lo < hi) {
    		if (height[lo] < height[hi]) {
    			if (height[++lo] < leftMax) {
    				area += leftMax - height[lo];
    			} else {
    				leftMax = height[lo];
    			}
    		} else {
    			if (height[--hi] < rightMax) {
    				area += rightMax - height[hi];
    			} else {
    				rightMax = height[hi];
    			}
    		}
    	}
        return area;
    }
}
