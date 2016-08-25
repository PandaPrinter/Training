public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
    	int row = A.length, col = B[0].length, t = A[0].length;
    	int[][] res = new int[row][col];
    	for (int i  = 0; i < row; i++) {
    		for (int m = 0; m < t; m++) {
    			if (A[i][m] != 0) {
    				for (int j = 0; j < col; j++) {
    					res[i][j] += A[i][m] * B[m][j];
    				}
    			}
    		}
    	}
    	return res;
    }
}

