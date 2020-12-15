package interviewQuestions;

import java.util.BitSet;

public class reverseBits {
    public int reverseBits(int n) {
        //bit by bit
        int result = 0;
        // int power = 31;
        // while (n != 0) {
        //     //n&1 retrieves the right-most bit in an integer, shift bits left power times,  then use right-shift to flip the next bit
        //   result += (n & 1) << power;
        //     n = n >> 1;
        //     power-=1;
        // }
        //using a for loop and more elegant syntax
        for (int i = 0; i < 32; i++) {
            result <<= 1;
            result = result | (n& 1);
            n >>= 1;
        }

        return result;
        // return Integer.reverse(n);
    }
}
