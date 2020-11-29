package interviewQuestions;
public class bestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int lowest = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < lowest) { //if today's price is lower than the lowest we've seen thus far
                lowest = prices[i]; 
            } else if (prices[i] - lowest > maxProfit) { //else if the dif between today's price & lowest we've seen will yield maxProfit, we have a new maxProfit 
                maxProfit =  prices[i] - lowest;
            }
        }
        return maxProfit;
    }
}
