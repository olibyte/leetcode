package interviewQuestions;

import java.util.HashSet;

public class findTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        // int result = -1;
        HashSet<Integer> mySet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (mySet.contains(nums[i])) {
                return nums[i];
            }
            mySet.add(nums[i]);
        }
        return nums[0];
    }
}
/*
class Solution {
    //Floyd's tortoise and hare, cycle detection
    public int findDuplicate(int[] nums) {
      // Find the intersection point of the two runners.
      int tortoise = nums[0];
      int hare = nums[0];
      do {
        tortoise = nums[tortoise];
        hare = nums[nums[hare]];
      } while (tortoise != hare);
  
      // Find the "entrance" to the cycle.
      tortoise = nums[0];
      while (tortoise != hare) {
        tortoise = nums[tortoise];
        hare = nums[hare];
      }
  
      return hare;
    }
  }
  */
