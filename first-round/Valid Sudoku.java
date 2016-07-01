public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!isValid(0, 8, i, i, board)) return false;
            if (!isValid(i, i, 0, 8, board)) return false;
        }
        for (int i = 2; i < 9; i += 3) {
            for (int j = 2; j < 9; j += 3) {
                if (!isValid(i - 2, i, j - 2, j, board)) return false;
            }
        }
        return true;
    }
    private boolean isValid(int x1, int x2, int y1, int y2, char[][] board) {
        Set set = new HashSet<>();
        for (int x = x1; x <= x2; x++) {
            for (int y = y1; y <= y2; y++) {
                if (board[x][y] != '.' && !set.add(board[x][y])) return false;
            }
        }
        return true;
    }
    
}