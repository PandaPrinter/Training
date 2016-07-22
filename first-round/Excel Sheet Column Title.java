public class Solution {
    public String convertToTitle(int n) {
        return (n <= 26) ? String.valueOf((char)('A' + (n - 1) % 26)) : convertToTitle((n - 1) / 26) + (char)('A' + (n - 1) % 26);
    }
    
}