public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int end = row * col - 1;
        int start = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int m = mid / col;
            int n = mid % col;
            if (matrix[m][n] == target) {
                return true;
            }
            if (matrix[m][n] < target) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return false;
    }
    
}