public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length, col = matrix[0].length;
        int lo = 0, hi = row * col - 1;
        while (lo < hi) {
        	int val = lo + (hi - lo) / 2;
        	int r = val / col;
        	int c = val % col;
        	if (matrix[r][c] == target) {
        		return true;
        	}
        	else if (matrix[r][c] < target) {
        		lo = val + 1;
        	}
        	else {
        		hi = val - 1;
        	}
        }
        return matrix[lo / col][lo % col] == target;
    }
}