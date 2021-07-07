import java.util.Arrays;

public class outOfBoundaryPaths {
    //brute force recursive
    // public int findPaths(int m, int n, int maxMove, int startRow, int
    // startColumn) {
    // if (startRow == m || startColumn == maxMove|| startRow < 0 || startColumn <
    // 0) return 1;
    // if (maxMove== 0) return 0;
    // return findPaths(m, n,maxMove- 1, startRow- 1, startColumn)
    // + findPaths(m, n,maxMove- 1, startRow+ 1, startColumn)
    // + findPaths(m, n,maxMove- 1, startRow, startColumn- 1)
    // + findPaths(m, n,maxMove- 1, startRow, startColumn+ 1);
    // }
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
}
