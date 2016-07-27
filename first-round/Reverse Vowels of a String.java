public class Solution {
    public String reverseVowels(String s) {
        String vowels = "aeiouAEIOU";
        char[] arr = s.toCharArray();
        int lo = 0, hi = s.length() - 1;
        while (lo < hi) {
            while (lo < hi && !vowels.contains(s.charAt(lo) + "")) lo++;
            while (lo < hi && !vowels.contains(s.charAt(hi) + "")) hi--;
            char temp = arr[hi];
            arr[hi] = arr[lo];
            arr[lo] = temp;
            lo++;
            hi--;
        }
        return String.valueOf(arr);
    }
    
}