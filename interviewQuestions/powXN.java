package interviewQuestions;

public class powXN {
    public double myPow(double x, int n) {
        //cheeky version
        // double result;
        // result = Math.pow(x, n);
        // return result;
        //O(logN) solution
        //decompose exponent into powers of 2, continually dividing problem into half

        //N = 9 = 2^3 + 2^0 = 1001 in binary. Then:    
        //x^9 = x^(2^3) * x^(2^0)
        //We can see that every time we encounter a 1 in the binary representation of N, we need to multiply the answer with x^(2^i) where i is the ith bit of the exponent. Thus, we can keep a running total of repeatedly squaring x - (x, x^2, x^4, x^8, etc) and multiply it by the answer when we see a 1.
        //To handle the case where N=INTEGER_MIN we use a long (64-bit) variable. Below is solution:
        double result = 1;
        long absoluteValue = Math.abs((long)n);
        while(absoluteValue > 0) {
            if((absoluteValue&1)==1)
                result *= x;
            absoluteValue >>= 1;
            x *= x;
        }
        if (n < 0) {
            return 1/result;
        } else {
            return result;
        }
    }
}
