package interviewQuestions;

import java.util.SortedSet;
import java.util.TreeSet;

public class firstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        //Add positive ints to a sorted set.
        SortedSet<Integer> positives = new TreeSet<Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                positives.add(nums[i]);
            }
        }
        boolean flag = true;
        int smallestNumber = 1;
        //walk through positives, incrementing smallestNumber by 1 each iteration. return the first missing entry. 
        while (flag) {
            if (!positives.contains(smallestNumber)) {
                flag = false;
                return smallestNumber;
            }
            smallestNumber++;
        }
        return 0;

        /**
         //OPTIMIZED SOLUTION: https://leetcode.com/problems/first-missing-positive/discuss/17214/Java-simple-solution-with-documentation
     int n = nums.length;
    
    // 1. mark numbers (num < 0) and (num > n) with a special marker number (n+1) 
    // (we can ignore those because if all number are > n then we'll simply return 1)
    for (int i = 0; i < n; i++) {
        if (nums[i] <= 0 || nums[i] > n) {
            nums[i] = n + 1;
        }
    }
    // note: all number in the array are now positive, and on the range 1..n+1
    
    // 2. mark each cell appearing in the array, by converting the index for that number to negative
    for (int i = 0; i < n; i++) {
        int num = Math.abs(nums[i]);
        if (num > n) {
            continue;
        }
        num--; // -1 for zero index based array (so the number 1 will be at pos 0)
        if (nums[num] > 0) { // prevents double negative operations
            nums[num] = -1 * nums[num];
        }
    }
    
    // 3. find the first cell which isn't negative (doesn't appear in the array)
    for (int i = 0; i < n; i++) {
        if (nums[i] >= 0) {
            return i + 1;
         */
    }

}
