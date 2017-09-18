package spiral_matrix;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
    	
    	int m = matrix.length;
    	if (m == 0) return new ArrayList<Integer>();
    	int n = matrix[0].length;
    	if (n == 0) return new ArrayList<Integer>();
        List<Integer> result = new ArrayList<Integer>();
        
        int minlength = m > n ? n : m;
        int layer = 0;
        
        while (minlength - 2 * layer > 1) {
        	for (int j = layer; j < n - 1 - layer; j ++) {
        		result.add(matrix[layer][j]);
        	}
        	for (int i = layer; i < m - 1 - layer; i ++) {
        		result.add(matrix[i][n - 1 - layer]);
        	}
        	for (int j = n - 1 - layer; j > layer; j --) {
        		result.add(matrix[m - 1 - layer][j]);
        	}
        	for (int i = m - 1 - layer; i > layer; i --) {
        		result.add(matrix[i][layer]);
        	}
        	layer ++;
        }
        
        if (minlength - 2 * layer == 1) {
        	if (m > n) {
        		for (int i = layer; i <= m - 1 - layer; i ++) {
        			result.add(matrix[i][layer]);
        		}
        	} else {
        		for (int j = layer; j <= n - 1 - layer; j ++) {
        			result.add(matrix[layer][j]);
        		}
        	}
        }
        
        return result;
    }
}
