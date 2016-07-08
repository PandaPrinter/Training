public class Solution {
    public String getPermutation(int n, int k) {
        int start = 1;
        int[] factorial = new int[n + 1];
        factorial[1] = start;
        for (int i = 2; i < n; i++) {
            start++;
            factorial[i] = start * factorial[i - 1];
        }
        String str = "";
        for (int i = 1; i <= n; i++) {
            str += i;
        }
        StringBuilder res = new StringBuilder();
        while (str.length() > 1) {
            int temp = factorial[--n];
            int val1 = (k - 1) / temp;
            int val2 = (k - 1) % temp;
            char c = str.charAt(val1);
            str = str.substring(0, val1) + str.substring(val1 + 1);
            res.append(c);
            k = val2 + 1;
        }
        res.append(str);
        return res.toString();
    }
    
}