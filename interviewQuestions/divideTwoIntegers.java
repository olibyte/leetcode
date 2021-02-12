package interviewQuestions;

public class divideTwoIntegers {
    public int divide(int dividend, int divisor) {
        //handle overflow
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        
        int result = 0;
        int a = Math.abs(dividend);//10
        int b = Math.abs(divisor);//3

        while (a - b >= 0) {
            int x = 0; //2**0 = 1
            while(a - (b << 1 << x) >=0) {
                x++; //result - 3
            }
            result += 1 << x;
            a -= b << x; //4 - (3<<0)
        }
        //
        if ( (dividend >= 0) == (divisor >= 0) ) {
            return result;
        } else {
            return -result;
        }   
    }
}
