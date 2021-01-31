package interviewQuestions;

public class stringToInteger {
    public int myAtoi(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int result = 0;
        int sign = 1;
        int i = 0;
        //discard whitespace
        s = s.trim();
        //check for pos/neg sign
        if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            if (s.charAt(i++) == '-') {
                sign = -1;
            } else {
                sign = 1;
            }
        }
        //build result checking for overflow conditions
        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') { //while a valid char
            if (result > Integer.MAX_VALUE / 10 || 
                (result == Integer.MAX_VALUE / 10 && s.charAt(i) - '0' > Integer.MAX_VALUE % 10)) {
                if (sign == 1) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }
            result = result * 10 + (s.charAt(i++) - '0');
        }
        return result * sign;
    }
}
