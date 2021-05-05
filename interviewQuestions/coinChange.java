package interviewQuestions;

class coinChange {
    //iterative
    public int coinChange(int[] coins, int amount) {
        if (amount < 1)
            return 0;
        int[] dp = new int[amount + 1];
        int sum = 0;

        while (++sum <= amount) {
            int min = -1;
            for (int coin : coins) {
                if (sum >= coin && dp[sum - coin] != -1) {
                    int temp = dp[sum - coin] + 1;
                    min = min < 0 ? temp : (temp < min ? temp : min);
                }
            }
            dp[sum] = min;
        }
        return dp[amount];

    }
    // recursive
    /*
     * public int coinChange(int[] coins, int amount) { if(amount<1) return 0;
     * return helper(coins, amount, new int[amount]); }
     * 
     * private int helper(int[] coins, int rem, int[] count) { // rem: remaining
     * coins after the last step; count[rem]: minimum number of coins to sum up to
     * rem if(rem<0) return -1; // not valid if(rem==0) return 0; // completed
     * if(count[rem-1] != 0) return count[rem-1]; // already computed, so reuse int
     * min = Integer.MAX_VALUE; for(int coin : coins) { int res = helper(coins,
     * rem-coin, count); if(res>=0 && res < min) min = 1+res; } count[rem-1] =
     * (min==Integer.MAX_VALUE) ? -1 : min; return count[rem-1]; }
     */
}