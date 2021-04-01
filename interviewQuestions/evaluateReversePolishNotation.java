package interviewQuestions;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class evaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        if (tokens.length == 1) {
            return Integer.parseInt(tokens[0]);
        }
     Stack<Integer> stack = new Stack<>();
        Map<String, Integer> map = new HashMap<>();
        map.put("+", 1);
        map.put("-", 2);
        map.put("*", 3);
        map.put("/", 4);
        
        int result = 0;
        int i = 0;
        while (i < tokens.length) {
            if (!map.containsKey(tokens[i])) {
                stack.push(Integer.parseInt(tokens[i]));
            } else {
                switch (map.get(tokens[i])) {
                    case 1: 
                        result = stack.pop() + stack.pop();
                        break;
                    case 2: 
                        result = -(stack.pop() - stack.pop());
                        break;
                    case 3: 
                        result = stack.pop() * stack.pop();
                        break;
                    case 4: 
                        int second = stack.pop();
                        int first = stack.pop();
                        result = first / second;
                        // result = stack.pop() / stack.pop();
                        break; 
                }
                stack.push(result);
            }
            i++;
        }
        return result;

    }
    

}
