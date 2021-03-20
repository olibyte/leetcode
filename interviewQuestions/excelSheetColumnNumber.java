package interviewQuestions;

import java.util.HashMap;

public class excelSheetColumnNumber {
    public int titleToNumber(String s) {
        int base = 26;
        int offset = 64;
        int sum = 0;
        int charValue = 0;
        for (int i = 0; i < s.length(); i++) {
           charValue = s.charAt(s.length()-i-1) - offset;
           sum = (int) (sum + charValue * Math.pow(base, i));
       }
       return sum;
       
    }
}
