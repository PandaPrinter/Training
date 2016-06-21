public class Solution {
    public int myAtoi(String str) {
        int index = 0, total = 0;
        int flag = 1;
        str = str.trim();
        if (str.equals("")) return 0;
        while (!str.equals("") && str.charAt(0) == '0') {
            str = str.substring(1);
        }
        if (!str.equals("") && (str.charAt(0) == '-' || str.charAt(0) == '+')) {
            flag = str.charAt(0) == '-' ? -1 : 1;
            str = str.substring(1);
        }
        if (str.equals("")) return 0;
        while (index < str.length()) {
            int digit = str.charAt(index) - '0';
            if (digit > 9 || digit < 0) break;
            if (Integer.MAX_VALUE / 10 < total || (Integer.MAX_VALUE / 10 == total && digit > 7)) {
                return flag == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            total = total * 10 + digit;
            index++;
        }
        return total * flag;
    }
    
}