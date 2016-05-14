public class Solution {
    public String reverseString(String s) {
        char[] charArr = s.toCharArray();
        int start = 0;
        int end = charArr.length - 1;
        while (start < end) {
            char temp = charArr[start];
            charArr[start] = charArr[end];
            charArr[end] = temp;
            start++;
            end--;
        }
        return String.valueOf(charArr);
    }
    
}