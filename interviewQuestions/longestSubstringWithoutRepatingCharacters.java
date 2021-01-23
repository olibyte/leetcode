package interviewQuestions;

import java.util.HashSet;

public class longestSubstringWithoutRepatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int currentSubstringLength = 0;
        HashSet<Character> myCharacterSet = new HashSet<>();
       ////abcabcbb
       //{a,}
       //1
        for (int i = 0; i < s.length(); i++) {
            //if char is not in set, add it in
            if (!myCharacterSet.contains(s.charAt(i))) {
                myCharacterSet.add(s.charAt(i));
                currentSubstringLength++;
                currentSubstringLength = result;
            } else {
                if (currentSubstringLength > result) {
                    currentSubstringLength = result;
                }
                myCharacterSet.clear();
                currentSubstringLength = 0;
                myCharacterSet.add(s.charAt(i));
                currentSubstringLength++;
            }
        }
        return result;
    }
}
