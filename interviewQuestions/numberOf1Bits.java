package interviewQuestions;

public class numberOf1Bits {
    public int hammingWeight (int n) {
        //cheeky
        // return Integer.bitCount(n);
        //loop and flip: check each bit using bitwise & operator (gives least significant bit of this number), if number of bits is 1, increment the bitcount.
        //use a mask and the shift operator to check each bit i.e. mask = 010 => mask <<= 1 => 100  
        /** 
        int numberOf1Bits = 0;
        int mask = 1;
        for(int i = 0; i < 32; i++) {
            if((n & mask) != 0) {
                numberOf1Bits++;
            }
            mask = mask << 1;
        }

        return numberOf1Bits;
        */
        //bit manipulation trick
        /**
        We can make the previous algorithm simpler and a little faster. Instead of checking every bit of the number, we repeatedly flip the least-significant 11-bit of the number to 00, and add 11 to the sum. As soon as the number becomes 00, we know that it does not have any more 11-bits, and we return the sum.
        The key idea here is to realize that for any number nn, doing a bit-wise AND of nn and n - 1n−1 flips the least-significant 11-bit in nn to 00.
        n:      110100
        n-1:    110011
        n&(n-1) 110000
        In the binary representation, the least significant 11-bit in nn always corresponds to a 00-bit in n - 1n−1. Therefore, anding the two numbers nn and n - 1n−1 always flips the least significant 11-bit in nn to 00, and keeps all other bits the same.
        Reference: https://leetcode.com/problems/number-of-1-bits/solution/
        */
        int sum = 0;
        while (n != 0) {
            sum++;
            n =  n & (n-1); 
        }
        return sum;
    }
}
