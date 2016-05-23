public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] minPath = new int[n];
        
        for (int i = 0; i < n; i++) {
            minPath[i] = triangle.get(n-1).get(i);
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                minPath[j] = Math.min(minPath[j], minPath[j+1]) + triangle.get(i).get(j);
            }
        }
        return minPath[0];
    }
    
}