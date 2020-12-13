package interviewQuestions;

public class powerOfThree {
    public boolean isPowerOfThree(int n) {
        if (n == 0)
            return false;
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
        //Integer limitation hack, 4 Byte integer's max positive value is 1162261467, therefore we can perform simple arithmetic:
        // return n > 0 && 1162261467 % n == 0;
    }

}
