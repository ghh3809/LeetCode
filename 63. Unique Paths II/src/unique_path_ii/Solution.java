package unique_path_ii;

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	if ((obstacleGrid.length == 0) || (obstacleGrid[0].length == 0)) return 0;
    	int m = obstacleGrid.length, n = obstacleGrid[0].length;
    	int[][] paths = new int[m][n];
    	boolean obstacleFlag = false;
    	for (int i = 0; i < m; i ++) {
    		if ((!obstacleFlag) && (obstacleGrid[i][0] == 0)) {
    			paths[i][0] = 1;
    		} else {
    			paths[i][0] = 0;
    			obstacleFlag = true;
    		}
    	}
    	obstacleFlag = false;
    	for (int j = 0; j < n; j ++) {
    		if ((!obstacleFlag) && (obstacleGrid[0][j] == 0)) {
    			paths[0][j] = 1;
    		} else {
    			paths[0][j] = 0;
    			obstacleFlag = true;
    		}
    	}
    	for (int i = 1; i < m; i ++) {
    		for (int j = 1; j < n; j ++) {
    			if (obstacleGrid[i][j] == 0) {
    				paths[i][j] = paths[i-1][j] + paths[i][j-1];
    			} else {
    				paths[i][j] = 0;
    			}
    		}
    	}
        return paths[m-1][n-1];
    }
}
