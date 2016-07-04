public class Solution {
    private static Set<Integer> col = new HashSet<>();
    private static Set<Integer> diagSet1 = new HashSet<>();
    private static Set<Integer> diagSet2 = new HashSet<>();
    public int totalNQueens(int n) {
        return helper(0, 0, n);
    }
    private int helper(int count, int row, int n) {
        for (int i = 0; i < n; i++) {
            if (col.contains(i)) {
                continue;
            }
            int diag1 = row - i;
            if (diagSet1.contains(diag1)) {
                continue;
            }
            int diag2 = row + i;
            if (diagSet2.contains(diag2)) {
                continue;
            }
            if (row == n - 1) {
                count++;
            }
            else {
                col.add(i);
                diagSet1.add(diag1);
                diagSet2.add(diag2);
                count = helper(count, row + 1, n);
                col.remove(i);
                diagSet1.remove(diag1);
                diagSet2.remove(diag2);
            }
        }
        return count;
    }
    
}