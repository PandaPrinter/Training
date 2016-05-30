public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int m = 0;
        int n = matrix[0].length - 1;
        
        while (m < matrix.length && n >= 0) {
            
            int i = matrix[m][n];
            
            if (i == target) return true;
            if (i > target) {
                n--;
            }
            if (i < target) {
                m++;
            }
        }
        
        return false;
    }
    
}