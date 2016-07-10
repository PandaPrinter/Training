public class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        digits[digits.length - 1]++;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            if (sum > 9) {
                digits[i] = sum - 10;
                carry = 1;
            }
            else {
                digits[i] = sum;
                carry = 0;
            }
        }
        if (carry == 0) return digits;
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        for (int i = 1; i < res.length; i++) {
            res[i] = digits[i - 1];
        }
        return res;
    }
    
}