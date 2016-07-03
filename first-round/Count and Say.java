public class Solution {
    public String countAndSay(int n) {
        return helper(n, "1");
    }
    private String helper(int n, String s) {
        if (n == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        char curr = s.charAt(0);
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == curr) {
                count++;
            }
            else {
                sb.append(count).append(curr);
                curr = c;
                count = 1;
            }
        }
        sb.append(count).append(curr);
        return helper(n - 1, sb.toString());
    }
    
}