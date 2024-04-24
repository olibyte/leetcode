public class finalPricesWithASpecialDiscount {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] result = new int[n];
        for (int i = 0; i < n -1; i++) {
           for (int j = i + 1; j < n; j++) {
                if (prices[j] <= prices[i]) {
                    result[i] = prices[i] - prices[j];
                    prices[i] -= prices[j];
                    break;
                } 
                else {
                    result[i] = prices[i];
                }
            }
        }
        result[n-1] = prices[n-1];
        return result;
    }
}
