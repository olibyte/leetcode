package interviewQuestions;

import java.util.HashSet;

public class containsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        /** walk through nums storing elements in a set. */
        HashSet mySet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            //if nums[i] is already in the set, we've found a duplicate 
            if (mySet.contains(nums[i])) {
                return false;
            }
            mySet.add(nums[i]);
        }
    return true;
    }
}
