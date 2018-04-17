package word_search;

class Solution {
    public boolean exist(char[][] board, String word) {
    	if (word.length() == 0) return true;
    	if ((board.length == 0) || (board[0].length == 0)) return false;
    	for (int i = 0; i < board.length; i ++) {
    		for (int j = 0; j < board[0].length; j ++) {
    			if (dfs(board, word, i, j, 0)) return true;
    		}
    	}
        return false;
    }
    public boolean dfs(char[][] board, String word, int i, int j, int index) {
    	int m = board.length, n = board[0].length;
    	if (index >= word.length()) return true;
    	if ((i < 0) || (i >= m) || (j < 0) || (j >= n) || (board[i][j] != word.charAt(index))) return false;
    	board[i][j] ^= 256;
    	boolean res = dfs(board, word, i - 1, j, index + 1) || dfs(board, word, i + 1, j, index + 1) ||
    			dfs(board, word, i, j - 1, index + 1) || dfs(board, word, i, j + 1, index + 1);
    	board[i][j] ^= 256;
    	return res;
    }
    public static void main(String args[]) {
    	System.out.println(new Solution().exist(new char[][] {new char[] {'a', 'b', 'a'}, new char[] {'b', 'c', 'd'}}, "aab"));
    }
}
