public class Solution {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        solve(board);
    }
    private boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if(isValid(c, board, i, j)) {
                            board[i][j] = c;
                            if (solve(board)) {
                                return true;
                            }
                            else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    private boolean isValid(char c, char[][] board, int i, int j) {
        for (int x = 0; x < 9; x++) {
            if (board[x][j] == c) {
                return false;
            }
            if (board[i][x] == c) {
                return false;
            }
        }
        for (int x = (i / 3) * 3; x < (i / 3) * 3 + 3; x++) {
            for (int y = (j / 3) * 3; y < (j / 3) * 3 + 3; y++) {
                if (board[x][y] == c) {
                    return false;
                }
            }
        }
        return true;
    }
}