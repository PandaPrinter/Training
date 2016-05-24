public class Solution {
    
    /*
     //method 1: backtracking
     private boolean flag = false;
     public boolean wordBreak(String s, Set<String> wordDict) {
     helper(s, wordDict, s.length());
     return flag;
     }
     private void helper(String s, Set<String> wordDict, int length) {
     if (length == 0) {
     flag = true;
     return;
     }
     for (int i = 0; i < s.length(); i++) {
     String str = s.substring(0, i+1);
     if (wordDict.contains(str)) {
     helper(s.substring(i+1), wordDict, length - str.length());
     }
     }
     }
     
     */
    
    //method 2:
    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
    
}