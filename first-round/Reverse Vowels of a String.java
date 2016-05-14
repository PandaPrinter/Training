public class Solution {
    public String reverseVowels(String s) {
        if (s == null) {
            return null;
        }
        String vowels = "aeiouAEIOU";
        char[] testArr = s.toCharArray();
        int start = 0;
        int end = testArr.length - 1;
        while (start < end) {
            while (start < end && !vowels.contains(testArr[start] + "")) {
                start++;
            }
            while (start < end && !vowels.contains(testArr[end] + "")) {
                end--;
            }
            
            char temp = testArr[start];
            testArr[start] = testArr[end];
            testArr[end] = temp;
            
            start++;
            end--;
        }
        return String.valueOf(testArr);
    }
    
}