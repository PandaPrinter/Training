public class Solution {
    public int reverse(int x) {
        while (x % 10 == 0 && x != 0) {
            x /= 10;
        }
        boolean flag = false;
        long temp = (long) x;
        if (x < 0) {
            temp = -temp;
            flag = true;
        }
        String s = String.valueOf(temp);
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.reverse();
        String res = String.valueOf(sb);
        long num = Long.valueOf(res);
        if ((!flag && num > Integer.MAX_VALUE) || (flag && num > Integer.MAX_VALUE - 1)) return 0;
        return flag ? (int) num * (-1) : (int) num;
    }
    
}