public class kInversePairsArray {
    public int kInversePairs(int n, int k) {
        int MOD = 1000000007;
        int[][] dp = new int[n+1][k+1];
        // vector<vector<int>> dp(n+1,vector<int>(k+1,0));
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int N = 1; N <= n; N++) {
            for (int K = 1; K <= k; K++) {
                dp[N][K] = (dp[N - 1][K] + dp[N][K - 1]) % MOD;
                if (K - N >= 0) {
                    dp[N][K] = (dp[N][K] - dp[N - 1][K - N] + MOD) % MOD;
                }
            }
        }
        return dp[n][k];
    }
}
