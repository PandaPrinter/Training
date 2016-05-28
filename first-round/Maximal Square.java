public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int result = 0;
        int[][] b = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i-1][j-1] == '1') {
                    b[i][j] = Math.min(Math.min(b[i-1][j], b[i-1][j-1]), b[i][j-1]) + 1;
                }
                result = Math.max(result,b[i][j]);
            }
        }
        return result * result;
    }
    
}