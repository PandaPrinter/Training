public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[j][i] = (i == 0 || j == 0) ? 1 : grid[j - 1][i] + grid[j][i - 1];
            }
        }
        return grid[m - 1][n - 1];
    }
    
}