package interviewQuestions;

import java.util.Stack;

public class validParentheses {
    public boolean isValid(String s) {
        //add parentheses to the stack
        //if the stack is empty return true
        // char[] myChars = s.toCharArray();
        char[] open = new char[]{'[','{', '('};
        char[] close = new char[]{']','}', ')'};
        // Stack<Character> open = new  
        Stack<Character> tagStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == open[0]) {
                if (s.)
            }
            if (s.charAt(i) == open[1]) {

            }
            if (s.charAt(i) == open[2]) {

            }
            if (tagStack.contains(s.charAt(i))) {

            }
            tagStack.push(s.charAt(i));
        }
        return false;   
    }
}
