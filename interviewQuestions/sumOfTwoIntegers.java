package interviewQuestions;

public class sumOfTwoIntegers {
    public int getSum(int a, int b) {
        // cheeky version
        // return Math.addExact(a, b);
        // bitwiseAND & sets each bit to 1 if both bits are 1
        while ((a&b) != 0) {
            // Zero-fill left shift - Shift left by pushing zeroes in from the right and
            // letting the leftmost bits fall off
            int h = (a&b) << 1;
            // XOR - Sets each bit to 1 if only one of the two bits is 1
            int l = a^b;
            a = h;
            b = l;
        }
        // bitwiseOR| sets each bit to 1 if any of the bits are 1
        return a|b;
    }
}
