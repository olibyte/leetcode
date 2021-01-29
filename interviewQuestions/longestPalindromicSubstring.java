package interviewQuestions;

public class longestPalindromicSubstring {
    public String longestPalindrome(String s) {
        // edge cases handling strings of length 1 or null
        if (s == null || s.length() < 1) return "";
        if (s.length() == 1) return s;
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            //if s is of odd length
            int len1 = expandAroundCenter(s, i, i);
            //if s is even length
            int len2 = expandAroundCenter(s, i, i + 1);
            //take the longest
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }
    
    private int expandAroundCenter(String s, int left, int right) {
        //2 pointer approach
        int L = left, R = right;
        //starting from the midpoint, working our way outwards, check the character on the left of the candidate is the same as the candidate on the right
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
