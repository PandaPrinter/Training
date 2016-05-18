public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int rowBegin = 0, rowEnd = n - 1, colBegin = 0, colEnd = n - 1;
        int value = 1;
        while (rowBegin <= rowEnd) {
            for (int i = colBegin; i <= colEnd; i++) {
                matrix[rowBegin][i] = value++;
            }
            rowBegin++;
            
            for (int i = rowBegin; i <= rowEnd; i++) {
                matrix[i][colEnd] = value++;
            }
            colEnd--;
            
            for (int i = colEnd; i >= colBegin; i--) {
                matrix[rowEnd][i] = value++;
            }
            rowEnd--;
            
            for (int i = rowEnd; i >= rowBegin; i--) {
                matrix[i][colBegin] = value++;
            }
            colBegin++;
        }
        return matrix;
    }
    
}