public class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int res = 0, sign = 1, num = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            
            if (!Character.isDigit(c) && c != ' ') {
                if (c == '(') {
                    stack.push(res);
                    stack.push(sign);
                    num = 0;
                    res = 0;
                    sign = 1;
                }
                
                else if (c == ')') {
                    res += num * sign;
                    res *= stack.pop();
                    res += stack.pop();
                    sign = 1;
                    num = 0;
                }
                else if (c == '+') {
                    res += num * sign;
                    num = 0;
                    sign = 1;
                }
                
                else if (c == '-') {
                    res += num * sign;
                    num = 0;
                    sign = -1;
                }
            }
        }
        
        if (num != 0) res += sign * num;
        return res;
    }
    
}