package word_search;

import java.util.Stack;

class Solution_v1 {
    public boolean exist(char[][] board, String word) {
    	if (word.length() == 0) return true;
    	if ((board.length == 0) || (board[0].length == 0)) return false;
    	int m = board.length, n = board[0].length;
    	Stack<boolean[][]> states = new Stack<boolean[][]>();
    	Stack<Integer> row = new Stack<Integer>(), col = new Stack<Integer>(), ind = new Stack<Integer>();
    	for (int i = 0; i < m; i ++) {
    		for (int j = 0; j < n; j ++) {
    			if (board[i][j] == word.charAt(0)) {
    				if (word.length() == 1) return true;
    				boolean[][] state = new boolean[m][n];
    				state[i][j] = true;
    				states.push(state); row.push(i); col.push(j); ind.push(1);
    			}
    		}
    	}
    	while (!states.isEmpty()) {
    		boolean[][] state = states.pop();
    		int i = row.pop(), j = col.pop(), index = ind.pop();
    		int[] ii = new int[] {i - 1, i + 1, i, i};
    		int[] jj = new int[] {j, j, j - 1, j + 1};
    		for (int k = 0; k < 4; k ++) {
    			i = ii[k]; j = jj[k];
    			if ((i >= 0) && (i < m) && (j >= 0) && (j < n) &&
    					(!state[i][j]) && (board[i][j] == word.charAt(index))) {
    				if (word.length() == index + 1) return true;
    				boolean[][] newState = new boolean[m][n];
        			deepCopy(state, newState);
        			newState[i][j] = true;
        			states.push(newState); row.push(i); col.push(j); ind.push(index + 1);
    			}
    		}
    	}
        return false;
    }
    public void deepCopy(boolean[][] origin, boolean[][] copy) {
    	for (int i = 0; i < origin.length; i ++) {
    		for (int j = 0; j < origin[0].length; j ++) {
    			copy[i][j] = origin[i][j];
    		}
    	}
    }
}