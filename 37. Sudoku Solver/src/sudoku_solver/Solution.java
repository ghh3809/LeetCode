package sudoku_solver;

import java.util.Stack;

public class Solution {
    
    private class Node {
        
        public char[][] board;
        public int i;
        public int j;
        
        public Node(char[][] board, int i, int j) {
            this.board = board;
            this.i = i;
            this.j = j;
        }
    }
    
    public void solveSudoku(char[][] board) {
        Stack<Node> stack = new Stack<>();
        stack.push(new Node(board, 0, 0));
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            char[][] bd = node.board;
            int i = node.i;
            int j = node.j;
            if (j > 8) {
            	i ++;
            	j = 0;
            }
            if (i > 8) {
            	for (int a = 0; a < 9; a ++) {
            		for (int b = 0; b < 9; b ++) {
            			board[a][b] = bd[a][b];
            		}
            	}
            	return;
            }
            solver(stack, bd, i, j);
        }
    }
    
    public void solver(Stack<Node> stack, char[][] board, int i, int j) {
        if (board[i][j] == '.') {
            boolean[] optionList = queryOption(board, i, j);
            for (int k = 0; k < 9; k ++) {
                if (!optionList[k]) {
                    char[][] newBoard = copyFrom(board);
                    newBoard[i][j] = (char)(k + '1');
                    stack.push(new Node(newBoard, i, j + 1));
                }
            }
        } else {
            stack.push(new Node(board, i, j + 1));
        }
    }
    
    public boolean[] queryOption(char[][] board, int i, int j) {
        boolean[] list = new boolean[9];
        for (int k = 0; k < 9; k ++) {
            if (board[i][k] != '.') list[board[i][k] - '1'] = true;
            if (board[k][j] != '.') list[board[k][j] - '1'] = true;
        }
        for (int a = i/3*3; a < (i/3+1)*3; a ++) {
            for (int b = j/3*3; b < (j/3+1)*3; b ++) {
                if (board[a][b] != '.') list[board[a][b] - '1'] = true;
            }
        }
        return list;
    }
    
    public char[][] copyFrom(char[][] src) {
        char[][] dst = new char[9][9];
        for (int i = 0; i < 9; i ++) {
            for (int j = 0; j < 9 ; j ++) {
                dst[i][j] = src[i][j];
            }
        }
        return dst;
    }
    
}
