public class Solution {
    public void rotate(int[][] matrix) {
        /*
         //method 1
         int size = matrix.length;
         int[][] res = new int[size][size];
         for (int i = size - 1; i >= 0; i--) {
         int column = size - 1 - i;
         for (int j = 0; j < size; j++) {
         res[j][column] = matrix[i][j];
         }
         }
         for (int i = 0; i < size; i++) {
         for (int j = 0; j < size; j++) {
         matrix[i][j] = res[i][j];
         }
         }
         */
        
        // method 2
        int n = matrix.length;
        for (int i = 0; i < (n + 1) / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = temp;
            }
        }
    }
    
}