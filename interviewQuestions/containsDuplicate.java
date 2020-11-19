package interviewQuestions;

import java.util.HashSet;
import java.util.Set;

public class containsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        /** walk through nums storing elements in a set. */
        Set<Integer> mySet = new HashSet<>(nums.length);
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
