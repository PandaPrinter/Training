public class Solution {
    
    private int n;
    private int m;
    
    public int numIslands(char[][] grid) {
        n = grid.length;
        if (n == 0) return 0;
        m = grid[0].length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    helper(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    private void helper(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == '0') return;
        grid[i][j] = '0';
        helper(grid, i - 1, j);
        helper(grid, i + 1, j);
        helper(grid, i, j + 1);
        helper(grid, i, j - 1);
    }
    
}