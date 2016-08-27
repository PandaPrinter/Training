public class NumMatrix {
	int[][] record;
	public NumMatrix (int[][] matrix) {
		record = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				record[i][j] = j == 0 ? matrix[i][j] : (matrix[i][j] + record[i - 1][j]);
			}
		}
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		int sum = 0;
		for (int i = row1; i <= row2; i++) {
			sum += col1 == 0 ? record[i][col2] : (record[i][col2] - record[i][col1 - 1]);
		}
		return sum;
	}

	public void update(int row, int col, int val) {
		int diff = col == 0 ? (val - record[row][col]) : (val - record[row][col] + record[row][col - 1]);
		for (int i = col; i < records[0].length; i++) {
			record[row][i] += diff;
		}
	}
}
