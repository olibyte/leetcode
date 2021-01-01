package interviewQuestions;

public class reverseInteger {
    public int reverse(int x) {
        // cheeky version
        String result = x < 0 ? new StringBuilder(String.valueOf(-x)).append("-").reverse().toString()
                : new StringBuilder(String.valueOf(x)).reverse().toString();
        try {
            return Integer.parseInt(result);
        } catch (Exception e) {
            return 0;
        }
    }
}
