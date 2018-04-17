package word_search;

import java.util.Stack;

class Solution_v2 {
    public boolean exist(char[][] board, String word) {
    	if (word.length() == 0) return true;
    	if ((board.length == 0) || (board[0].length == 0)) return false;
    	int m = board.length, n = board[0].length;
    	Stack<Integer> row = new Stack<Integer>(), col = new Stack<Integer>(), ind = new Stack<Integer>();
    	for (int outeri = 0; outeri < m; outeri ++) {
    		for (int outerj = 0; outerj < n; outerj ++) {
    			if (board[outeri][outerj] == word.charAt(0)) {
    				if (word.length() == 1) return true;
    				row.push(outeri); col.push(outerj); ind.push(1);
    				
    				while (!ind.isEmpty()) {
    		    		int i = row.pop(), j = col.pop(), index = ind.pop();
    		    		if (index == -1) {
    		    			board[i][j] ^= 256;
    		    			continue;
    		    		}
    		    		
    		    		row.push(i); col.push(j); ind.push(-1);
    		    		int[] ii = new int[] {i - 1, i + 1, i, i};
    		    		int[] jj = new int[] {j, j, j - 1, j + 1};
    		    		for (int k = 0; k < 4; k ++) {
    		    			int newi = ii[k], newj = jj[k];
    		    			if ((newi >= 0) && (newi < m) && (newj >= 0) && (newj < n) &&
    		    					(board[newi][newj] == word.charAt(index))) {
    		    				if (word.length() == index + 1) return true;
    		        			row.push(newi); col.push(newj); ind.push(index + 1);
    		    			}
    		    		}
    		    		board[i][j] ^= 256;
    		    	}
    			}
    		}
    	}
        return false;
    }
}
