package largest_rectangle_in_histogram;

import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> increment = new Stack<Integer>();
        int maxSize = 0;
        for (int i = 0; i <= heights.length; i ++) {
            int currentHeight = 0;
            if (i == heights.length) currentHeight = -1; else currentHeight = heights[i];
            if ((increment.isEmpty()) || (currentHeight >= heights[increment.peek()])) {
                increment.push(i);
            } else if (currentHeight < heights[increment.peek()]) {
                int newSize = heights[increment.pop()] * (increment.isEmpty() ? i : i - 1 - increment.peek());
                if (newSize > maxSize) maxSize = newSize;
                i --;
            }
        }
        return maxSize;
    }
}
