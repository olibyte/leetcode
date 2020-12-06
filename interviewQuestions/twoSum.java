package interviewQuestions;

import java.util.HashMap;

public class twoSum {
    public int[] twoSum(int[] nums, int target) {
        // int[] result = new int[2];
        /**
         * //brute force for (int i = 0; i < nums.length; i++) { for (int j = i + 1; j <
         * nums.length; j++) { if ((nums[i] + nums[j]) == target) { result[0] = i;
         * result[1] = j; } } }
         */
        /**
         * //two pass hashmap HashMap<Integer,Integer> myMap = new HashMap<>(); for (int
         * i = 0; i < nums.length; i++) { myMap.put(nums[i], i); } for (int i =0;
         * i<nums.length; i++) { int complement = target - nums[i]; //is the compliment
         * in the table? make sure complement being looked up is not actually i. if
         * (myMap.containsKey(complement) && myMap.get(complement) != i) { return new
         * int[] {i, myMap.get(complement)}; } } throw new IllegalArgumentException("No
         * solution found.");
         */
        // one-pass hashmap
        HashMap<Integer, Integer> myQuickMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (myQuickMap.containsKey(complement)) {
                return new int[] { myQuickMap.get(complement), i };
            }
            myQuickMap.put(nums[i], i);
        }
        throw new IllegalArgumentException("Solution not found");
    }
}
