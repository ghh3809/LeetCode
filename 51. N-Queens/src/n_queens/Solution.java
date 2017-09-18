package n_queens;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class Solution {
	
    public List<List<String>> solveNQueens(int n) {
    	
    	Stack<boolean[][]> states = new Stack<boolean[][]>();
    	Stack<boolean[][]> abandons = new Stack<boolean[][]>();
    	Stack<Integer> layers = new Stack<Integer>();
    	Stack<Integer> columns = new Stack<Integer>();
    	List<List<String>> results = new LinkedList<>();
    	states.push(new boolean[n][n]);
    	abandons.push(new boolean[n][n]);
    	layers.push(0);
    	columns.push(0);
    	
    	while (!states.isEmpty()) {
    		
    		boolean[][] state = states.pop();
    		boolean[][] abandon = abandons.pop();
    		int layer = layers.pop();
    		
    		for (int j = 0; j < n; j ++) {
    			if (!abandon[layer][j]) {
    				
    				if (layer == n - 1) {
    					
    					List<String> result = new LinkedList<String>();
        				for (int i = 0; i < n-1; i ++) {
        					String s = new String();
        					for (int k = 0; k < n; k ++) {
        						s += (state[i][k] ? 'Q' : '.');
        					}
        					result.add(s);
        				}
        				String s = new String();
    					for (int k = 0; k < n; k ++) {
    						s += ((k == j) ? 'Q' : '.');
    					}
    					result.add(s);
        				results.add(result);
        				continue;
        				
    				} else {
    					
    					boolean[][] newstate = new boolean[n][n];
    					for (int i = 0; i < n; i ++) {
    						for (int k = 0; k < n; k ++) {
    							newstate[i][k] = state[i][k];
    						}
    					}    
    					newstate[layer][j] = true;
    					states.push(newstate);
    					
    					boolean[][] newabandon = new boolean[n][n];
    					for (int i = 0; i < n; i ++) {
    						for (int k = 0; k < n; k ++) {
    							newabandon[i][k] = abandon[i][k];
    						}
    					}    
    					//TODO: refresh abandon
    					for (int i = layer + 1, bias = 1; i < n; i ++, bias ++) {
    						newabandon[i][j] = true;
    						if (j - bias >= 0) newabandon[i][j - bias] = true;
    						if (j + bias <  n) newabandon[i][j + bias] = true;
    					}
    					abandons.push(newabandon);
    					
    					layers.push(layer + 1);
    					
    				}
    				
    			}
			}
    	}
        return results;
    }
}
