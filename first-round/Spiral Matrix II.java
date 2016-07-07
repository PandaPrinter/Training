public class Solution {
    public int[][] generateMatrix(int n) {
        int rowStart = 0, rowEnd = n - 1, colStart = 0, colEnd = n - 1;
        int[][] res = new int[n][n];
        int num = 1;
        while (num <= Math.pow(n, 2)) {
            for (int i = colStart; i <= colEnd; i++) {
                res[rowStart][i] = num;
                num++;
            }
            rowStart++;
            for (int i = rowStart; i <= rowEnd; i++) {
                res[i][colEnd] = num;
                num++;
            }
            colEnd--;
            if (rowStart <= rowEnd) {
                for (int i = colEnd; i >= colStart; i--) {
                    res[rowEnd][i] = num;
                    num++;
                }
                rowEnd--;
            }
            if (colStart <= colEnd) {
                for (int i = rowEnd; i >= rowStart; i--) {
                    res[i][colStart] = num;
                    num++;
                }
                colStart++;
            }
        }
        return res;
    }
    
}