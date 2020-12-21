package interviewQuestions;

public class factorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int[] memo = new int[n];
        int result = 0;
        int sum = 0;
        // memo[0] = 0;
        // memo[1] = 1;
        // memo[2] = 2;
        // memo[3] = 6;
        for (int i = n; n > 0; i--) {
            memo[i] = n*i-1;
            sum+= memo[i];
        }
        while (sum % 10 == 0) {
            result += 1;
            sum /= 10;
        }
        return result;
    }
}
