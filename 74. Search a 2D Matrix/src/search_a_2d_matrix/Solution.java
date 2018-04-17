package search_a_2d_matrix;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int len1 = matrix.length;
        if (len1 == 0) return false;
        int len2 = matrix[0].length;
        if (len2 == 0) return false;
        int lo = 0, hi = len1;
        while(lo != hi) {
            int mi = (lo + hi) / 2;
            if (matrix[mi][0] > target) hi = mi; else lo = mi + 1;
        }
        if (lo == 0) return false;
        int lo2 = 0, hi2 = len2;
        while(lo2 != hi2) {
            int mi = (lo2 + hi2) / 2;
            if (matrix[lo-1][mi] > target) hi2 = mi; else lo2 = mi + 1;
        }
        if (lo2 == 0) return false;
        if (matrix[lo-1][lo2-1] == target) return true;
        else return false;
    }
}
