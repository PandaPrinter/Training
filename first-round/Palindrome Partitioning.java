public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        List<String> curr = new ArrayList<>();
        helper(res, curr, s, s.length());
        return res;
    }
    
    private void helper(List<List<String>> res, List<String> curr, String s, int len) {
        if (len == 0) {
            res.add(new ArrayList<String>(curr));
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            String str = s.substring(0, i + 1);
            if (isPalindrome(str, 0, i)) {
                curr.add(str);
                helper(res, curr, s.substring(i+1), len - str.length());
                curr.remove(curr.size() - 1);
            }
        }
    }
    
    // method 1:
    /*
     private boolean isPalindrome(String s) {
     StringBuilder sb = new StringBuilder();
     sb.append(s);
     return sb.toString().equals(sb.reverse().toString());
     }
     */
    
    // method 2:
    private boolean isPalindrome(String s, int low, int high) {
        while(low<high) if(s.charAt(low++)!=s.charAt(high--)) return false;
        return true;
    }
    
}