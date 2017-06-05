package valid_sudoku;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i ++) {
            boolean[] list = new boolean[9];
            for (int j = 0; j < 9; j ++) {
                if (board[i][j] != '.') {
                    if (list[board[i][j] - '1']) return false; else list[board[i][j] - '1'] = true;
                }
            }
        }
        for (int i = 0; i < 9; i ++) {
            boolean[] list = new boolean[9];
            for (int j = 0; j < 9; j ++) {
                if (board[j][i] != '.') {
                    if (list[board[j][i] - '1']) return false; else list[board[j][i] - '1'] = true;
                }
            }
        }
        for (int i = 0; i < 3; i ++) {
            for (int j = 0; j < 3; j ++) {
                boolean[] list = new boolean[9];
                for (int a = 3 * i; a < 3 * i + 3; a ++) {
                    for (int b = 3 * j; b < 3 * j + 3; b ++) {
                        if (board[a][b] != '.') {
                            if (list[board[a][b] - '1']) return false; else list[board[a][b] - '1'] = true;
                        }
                    }
                }
            }
        }
        return true;
    }
}
