public class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        String[] arr = s.split("\\s+");
        if (arr.length == 0) return 0;
        return arr[arr.length - 1].length();
    }
    
}