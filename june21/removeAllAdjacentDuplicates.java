import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class removeAllAdjacentDuplicates {
    public String removeDuplicates(String s) {
        //use a stack to greedily process all chars.
        Stack<Character> stack = new Stack<Character>();
        int n = s.length();

        for(int i = 0;i < n; i++){
            if(stack.empty() || stack.peek() != s.charAt(i)){
                stack.add(s.charAt(i));
            }
            else{
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.empty()){
            sb.append(stack.pop());
        }
        return new String(sb.reverse());
    }
}
