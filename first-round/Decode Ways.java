public class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        if (len == 0) {
            return 0;
        }
        int[] res = new int[len+1];
        res[0] = 1;
        res[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= len; i++) {
            int value1 = Integer.valueOf(s.substring(i - 1, i));
            int value2 = Integer.valueOf(s.substring(i - 2, i));
            if (value1 >= 1 && value1 <= 9) {
                res[i] += res[i-1];
            }
            if (value2 >= 10 && value2 <= 26) {
                res[i] += res[i-2];
            }
        }
        return res[len];
    }
    
}