public class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= p.length(); i++) {
            boolean flag = false;
            for (int j = 0; j <= s.length(); j++) {
                flag = dp[i - 1][j] || flag;
                if (p.charAt(i - 1) == '*') {
                    dp[i][j] = flag || i == 1;
                }
                else {
                    if (j > 0 && (p.charAt(i - 1) == '?' || p.charAt(i - 1) == s.charAt(j - 1))) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[p.length()][s.length()];
    }
}
