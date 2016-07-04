public class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<>();
        helper(res, board, 0);
        return res;
    }
    private void helper(List<List<String>> res, char[][] board, int col) {
        if (col == board.length) {
            res.add(construct(board));
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if (valid(board, col, i)) {
                board[i][col] = 'Q';
                helper(res, board, col + 1);
                board[i][col] = '.';
            }
        }
    }
    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for(char[] row : board) {
            res.add(String.valueOf(row));
        }
        return res;
    }
    private boolean valid(char[][] board, int col, int row) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'Q' && (i + col == j + row || i == row || col + row == i + j)) {
                    return false;
                }
            }
        }
        return true;
    }
    
}