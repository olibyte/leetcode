package interviewQuestions;

import java.util.HashSet;

public class longestSubstringWithoutRepatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int left = 0;
        HashSet<Character> myCharacterSet = new HashSet<>();
        
        for (int right = 0; right < s.length(); right++) {
            //if char is not in set, add it in
            while (myCharacterSet.contains(s.charAt(right))) {
                myCharacterSet.remove(s.charAt(left));
                left ++;
            }
            myCharacterSet.add(s.charAt(right));
            result = Math.max(result, right-left + 1);    
        }
        return result;
    }
}
