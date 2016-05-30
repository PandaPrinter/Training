public class Solution {
    public int hIndex(int[] citations) {
        
        /*
         // method 1:
         int len = citations.length;
         Arrays.sort(citations);
         for (int i = 0; i < len; i++) {
         if (citations[i] >= len - i) return len - i;
         }
         return 0;
         */
        
        //method 2:
        int len = citations.length;
        if (len < 1) return 0;
        int[] counts = new int[len+1];
        for (int i : citations) {
            if (i > len) counts[len]++;
            else counts[i]++;
        }
        int res = 0;
        for (int k = len; k >= 0; k--) {
            res += counts[k];
            if (res >= k) return k;
        }
        return 0;
    }
    
}