public class Solution {
    public int maxProfit(int[] prices) {
        //buy[i] = max(sell[i-2]-price, buy[i-1])
        //sell[i] = max(buy[i-1]+price, sell[i-1])
        
        int sell = 0, prevSell = 0, buy = Integer.MIN_VALUE, prevBuy = 0;
        for (int price : prices) {
            prevBuy = buy;
            buy = Math.max(prevSell - price, prevBuy);
            prevSell = sell;
            sell = Math.max(buy + price, prevSell);
        }
        return sell;
    }
}