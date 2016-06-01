public class Solution {
    public int[] countBits(int num) {
        
        /*
         //method 1:
         int[] res = new int[num+1];
         for (int i = 0; i < num+1; i++) {
         res[i] = res[i/2] + i%2;
         }
         return res;
         */
        
        //method 2:
        int[] res = new int[num+1];
        int pow = 1;
        for (int i = 1, t = 0; i < num+1; i++, t++) {
            if (i == pow) {
                pow *= 2;
                t = 0;
            }
            res[i] = res[t] + 1;
        }
        return res;
    }
}