package interviewQuestions;

import java.util.Arrays;

public class validAnagram {
    public boolean isAnagram(String s, String t) {
        
        if (s.length() != t.length())
            return false;
        // char[] sChars = s.toCharArray();
        // char[] tChars = t.toCharArray();
        // Arrays.sort(sChars);
        // Arrays.sort(tChars);
        // return Arrays.equals(sChars, tChars);
        int[] charCount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a']++;
            charCount[t.charAt(i) - 'a']--;
        }
        for (int count : charCount) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
