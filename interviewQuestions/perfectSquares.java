package interviewQuestions;

class perfectSquares {
    public int numSquares(int n) {
        int memo[] = new int[n + 1];
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++)
                min = Math.min(1 + memo[i - (j * j)], min);
            memo[i] = min;
        }
        return memo[n];
    }
}