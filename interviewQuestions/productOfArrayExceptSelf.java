package interviewQuestions;

import java.util.ArrayList;

//Input:  [1,2,3,4]
//Output: [24,12,8,6]
// public int compute()
public class productOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        //partitioning nums into L and R sub-arrays, the L sub-array at index 0 will have no elements to the left of it, so it'll be 1.
        result[0] = 1; 
        //populate result with product of L sub-array * nums
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i-1] * nums[i-1];
        }
        //product of all elements to the right
        int R = 1; 
        //walk backwards populating result[i] with product of elements to the right and itself
        for (int i = nums.length-1; i >= 0; i--) {
            result[i] = result[i] * R;
            //update R
            R *= nums[i];
        }

        return result;
    }
}
