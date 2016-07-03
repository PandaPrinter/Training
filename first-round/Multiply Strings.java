public class Solution {
    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int[] arr = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int temp = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int val = arr[i + j + 1] + temp;
                arr[i + j + 1] = val % 10;
                arr[i + j] += val / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            if (sb.length() != 0 || i != 0) {
                sb.append(i);
            }
        }
        return sb.length() == 0 ? "0" : String.valueOf(sb);
    }
    
}