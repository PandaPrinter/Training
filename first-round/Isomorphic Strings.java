public class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] arr = new int[512];
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i), b = t.charAt(i);
            if (arr[a] != arr[b + 256]) return false;
            arr[a] = arr[b + 256] = i + 1;
        }
        return true;
    }
    
}