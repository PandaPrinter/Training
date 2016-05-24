public class Solution {
    public int minCut(String s) {
        if (s.length() == 0) return 0;
        int n = s.length();
        int[] dp = new int[n];
        boolean[][] isPalindrome = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i] = i;
            isPalindrome[i][i] = true;
            for (int j = 0; j <= i; j++) {
                if ((i - j <= 1 || isPalindrome[j+1][i-1]) && s.charAt(j) == s.charAt(i)) {
                    if (j == 0) {
                        dp[i] = 0;
                    }
                    else {
                        isPalindrome[j][i] = true;
                        dp[i] = Math.min(dp[i], dp[j-1] + 1);
                    }
                }
            }
        }
        return dp[n -1];
    }
    
}