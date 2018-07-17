package maximal_rectangle;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        int size1 = matrix.length;      if (size1 == 0) return 0;
        int size2 = matrix[0].length;   if (size2 == 0) return 0;
        int[] heights = new int[size2];
        int maxSize = 0;
        for (int i = 0; i < size1; i ++) {
            for (int j = 0; j < size2; j ++) {
                if (matrix[i][j] != '0') heights[j] ++; else heights[j] = 0;
            }
            maxSize = Math.max(maxSize, largestRectangleArea(heights));
        }
        return maxSize;
    }
    private int largestRectangleArea(int[] heights) {
        // Initialize
        if (heights.length == 0) return 0;
        int[] lessLeft  = new int[heights.length];
        int[] lessRight = new int[heights.length];
        lessLeft[0] = -1;
        lessRight[heights.length - 1] = heights.length;
        
        // Calculate lessLeft and lessRight
        for (int i = 1; i < heights.length; i ++) {
            int candidate = i - 1;
            while ((candidate >= 0) && (heights[candidate] >= heights[i])) {
                candidate = lessLeft[candidate];
            }
            lessLeft[i] = candidate;
        }
        for (int i = heights.length - 2; i >= 0; i --) {
            int candidate = i + 1;
            while ((candidate < heights.length) && (heights[candidate] >= heights[i])) {
                candidate = lessRight[candidate];
            }
            lessRight[i] = candidate;
        }
        
        // Calculate maximum rectangle
        int maxSize = 0;
        for (int i = 0; i < heights.length; i ++) {
            maxSize = Math.max(maxSize, heights[i] * (lessRight[i] - lessLeft[i] - 1));
        }
        
        return maxSize;
    }
}
