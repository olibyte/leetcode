package interviewQuestions;

import java.util.Arrays;
import java.util.HashSet;

public class missingNumber {
    public int missingNumber(int[] nums) {
        //store nums in a hashset O(n) time, O(n) space
        /** 
        HashSet<Integer> numSet = new HashSet<Integer>();
        for (int num : nums) {
            numSet.add(num);
        }
        for (int number = 0; number < nums.length + 1; number++) {
            //if the number is not in the numSet
            if (!numSet.contains(number)) {
                return number;
            }
        }
        return -1;
        */
        //bit manipulation - XOR every index with the num[i] and we will be left with the missing num
        // index: 0,1,2,3
        // value: 0,1,3,4
        // XOR^=: 4^(0^0)^(1^1)^(2^3)^(3^4) => (4^4) ^ (0^0) ^ (1^1) ^ (3^3) ^ 2 => 0 ^ 0 ^ 0 ^ 2 => 2
        int missingNum = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missingNum ^= nums[i];
        }
        return missingNum;
    }
}
