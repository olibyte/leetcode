import java.util.Stack;

public class removeOuterMostParentheses {
    public String removeOuterParentheses(String S) {

    StringBuilder result = new StringBuilder();
	int start = 0;
	Stack<Character> stck = new Stack<Character>();

	for(int i = 0; i < S.length(); i++) {
		char c = S.charAt(i);
		result.append(c);

		if(!stck.isEmpty() && stck.peek() == '(' && c == ')') {
			stck.pop();
		}else {
			stck.push(c);
		}
		if(stck.isEmpty()) {
			// we found primitive pair
			result.deleteCharAt(start);
			result.deleteCharAt(result.length()-1);
			start = result.length();
		}
	}
	return result.toString();
}

/*  Ref: https://leetcode.com/problems/remove-outermost-parentheses/discuss/270022/JavaC%2B%2BPython-Count-Opened-Parenthesis
	optimized, no stack
 * 	opened count the number of opened parenthesis.
	Add every char to the result,
	until the first left parenthesis, and the last right parenthesis.

	Time Complexity:
	O(N) Time, O(N) space
 */
// public String removeOuterParentheses(String S) {
// 	StringBuilder s = new StringBuilder();
// 	int opened = 0;
// 	for (char c : S.toCharArray()) {
// 		if (c == '(' && opened++ > 0) s.append(c);
// 		if (c == ')' && opened-- > 1) s.append(c);
// 	}
// 	return s.toString();
//     }
}
