package interviewQuestions;

public class bestTimeToBuyAndSellStockii {
    public int maxProfit(int[] prices) { 
        int maxProfit = 0;
        //walk through prices
        for (int i = 1; i < prices.length; i++) {
            //if the stock appreciates tomorrow
            if (prices[i] > prices[i-1]) {
                //we buy today and make a profit tomorow.
                //profit is difference of today's and tomorrow's price.
                maxProfit = maxProfit + prices[i] - prices[i-1];
            }
        }
        return maxProfit;
    }
}
