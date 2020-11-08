package interviewQuestions;

import java.util.HashMap;

public class majorityElement {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            //walk through nums
            //have we seen the element?
            if (frequencyMap.containsKey(nums[i])) {
                frequencyMap.put(nums[i], frequencyMap.get(nums[i]) + 1);
            } else {
                frequencyMap.put(nums[i], 1);
            }
        }
        HashMap.Entry<Integer, Integer> majorityEntry = null;
        for (HashMap.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
                majorityEntry = entry;
            }
        }
        return majorityEntry.getKey();
    }
}
