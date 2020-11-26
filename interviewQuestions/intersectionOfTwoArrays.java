package interviewQuestions;

import java.util.ArrayList;
import java.util.HashMap;

public class intersectionOfTwoArrays {
    // iterate through longest array
    // store elements + frequency into Hashmap
    // iterate through shorter array
    // if Hashmap contains shorter[i]
    // result.add(shorter[i]); Hashmap.decrementfrequency
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> resultList = new ArrayList<Integer>();
        HashMap<Integer, Integer> myMap = new HashMap<Integer, Integer>();
        //store elements
        for (int i = 0; i < nums1.length; i++) {
            if (!myMap.containsKey(nums1[i])) {
                myMap.put(nums1[i], 1);
            } else {
                myMap.put(nums1[i], (myMap.get(nums1[i])) + 1);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            if(myMap.containsKey(nums2[i])) {
                resultList.add(nums2[i]);
                myMap.put(nums2[i], (myMap.get(nums2[i])) -1);
                //now we've decremented, if the freq is now 0 we should remove it from the map
                if (myMap.get(nums2[i]) == 0) {
                    myMap.remove(nums2[i]);
                }
            }
        }
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }
}
