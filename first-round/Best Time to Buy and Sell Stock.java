public class Solution {
    public int maxProfit(int[] prices) {
        int maxCurr = 0, maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            maxCurr = Math.max(0, maxCurr += prices[i] - prices[i-1]);
            maxProfit = Math.max(maxCurr, maxProfit);
        }
        return maxProfit;
    }
    
}