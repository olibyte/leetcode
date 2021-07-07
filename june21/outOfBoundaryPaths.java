import java.util.Arrays;

public class outOfBoundaryPaths {
    // brute force recursive
    /*
    public int findPaths(int m, int n, int maxMove, int startRow, int
    startColumn) {
    if (startRow == m || startColumn == maxMove|| startRow < 0 || startColumn <
    0) return 1;
    if (maxMove== 0) return 0;
    return findPaths(m, n,maxMove- 1, startRow- 1, startColumn)
    + findPaths(m, n,maxMove- 1, startRow+ 1, startColumn)
    + findPaths(m, n,maxMove- 1, startRow, startColumn- 1)
    + findPaths(m, n,maxMove- 1, startRow, startColumn+ 1);
    }
    */
    //recursion with memoization
    int M = 1000000007;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] memo = new int[m][n][maxMove + 1];
        for (int[][] l : memo)
            for (int[] sl : l)
                Arrays.fill(sl, -1);
        return findPaths(m, n, maxMove, startRow, startColumn, memo);
    }

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn, int[][][] memo) {
        if (startRow == m || startColumn == n || startRow < 0 || startColumn < 0)
            return 1;
        if (maxMove == 0)
            return 0;
        if (memo[startRow][startColumn][maxMove] >= 0)
            return memo[startRow][startColumn][maxMove];
        memo[startRow][startColumn][maxMove] = ((findPaths(m, n, maxMove - 1, startRow - 1, startColumn, memo) + findPaths(m, n, maxMove - 1, startRow + 1, startColumn, memo)) % M
                + (findPaths(m, n, maxMove - 1, startRow, startColumn - 1, memo) + findPaths(m, n, maxMove - 1, startRow, startColumn + 1, memo)) % M) % M;
        return memo[startRow][startColumn][maxMove];
    }
    //dynamic programming solution
    /*
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
          int M = 1000000000 + 7;
          int dp[][] = new int[m][n];
          dp[startRow][startColumn] = 1;
          int count = 0;
          for (int moves = 1; moves <= maxMove; moves++) {
            int[][] temp = new int[m][n];
            for (int i = 0; i < m; i++) {
              for (int j = 0; j < n; j++) {
                if (i == m - 1) count = (count + dp[i][j]) % M;
                if (j == n - 1) count = (count + dp[i][j]) % M;
                if (i == 0) count = (count + dp[i][j]) % M;
                if (j == 0) count = (count + dp[i][j]) % M;
                temp[i][j] = (
                    ((i > 0 ? dp[i - 1][j] : 0) + (i < m - 1 ? dp[i + 1][j] : 0)) % M +
                    ((j > 0 ? dp[i][j - 1] : 0) + (j < n - 1 ? dp[i][j + 1] : 0)) % M
                ) % M;
              }
            }
            dp = temp;
          }
          return count;
        }     
        */ 
}
