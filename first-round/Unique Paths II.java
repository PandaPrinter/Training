public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int width = obstacleGrid[0].length;
        int[] res = new int[width];
        res[0] = 1;
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < width; j++) {
                if (obstacleGrid[i][j] == 1) {
                    res[j] = 0;
                }
                else if (j > 0){
                    res[j] += res[j - 1];
                }
            }
        }
        return res[width - 1];
    }
    
}