public class Solution {
    public String convertToTitle(int n) {
        StringBuilder res = new StringBuilder();
        
        while (n > 0) {
            n--;
            int r = n % 26;
            res.insert(0, (char) ('A' + r));
            n /= 26;
        }
        return String.valueOf(res);
    }
    
}