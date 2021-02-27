package interviewQuestions;

public class uniquePaths {
    public static int uniquePaths(int m, int n) {
        int[][] memo = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            Arrays.fill(memo[i],-1);
        }
        return helper(m,n,memo);
    }

    public static int helper(int m,int n,int[][] memo){
        if(m == 0 || n == 0) return 0;
        if(m == 1 && n == 1) return 1;
        if(memo[m][n] != -1) return memo[m][n];
        int pathCount = helper(m-1,n,memo);
        pathCount += helper(m,n-1,memo);
        memo[m][n] = pathCount;
        return pathCount;
    }
}
