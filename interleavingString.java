public class interleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
    if (s1.length() + s2.length() != s3.length())
        return false;
    int m = s1.length(), n = s2.length();
    
    boolean[] dp = new boolean[n+1];
    dp[0] = true;
    for (int i = 1; i <= n; ++i) {
        dp[i] = dp[i-1] && s3.charAt(i-1) == s2.charAt(i-1);
    }
    
    for (int i = 1; i <= m; ++i) {
        for (int j = 0; j <= n; ++j) {
            if (j == 0)
                dp[j] = dp[j] && s3.charAt(i-1) == s1.charAt(i-1);
            else
                dp[j] = (dp[j] && s3.charAt(i+j-1) == s1.charAt(i-1)) || (dp[j-1] && s3.charAt(i+j-1) == s2.charAt(j-1));
        }
    }
    return dp[n];
    }
}
