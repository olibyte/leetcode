import java.util.ArrayList;
import java.util.List;

class generateParentheses {
    /**
    //brute force
    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    public void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (isValid(current))
                result.add(new String(current));
        } else {
            current[pos] = '(';
            generateAll(current, pos+1, result);
            current[pos] = ')';
            generateAll(current, pos+1, result);
        }
    }

    public boolean isValid(char[] current) {
        int balance = 0;
        for (char c: current) {
            if (c == '(') balance++;
            else balance--;
            if (balance < 0) return false;
        }
        return (balance == 0);
    }
     */
    //recursion with backtracking
        public List<String> generateParenthesis(int n) {
            List<String> ans = new ArrayList();
            backtrack(ans, "", 0, 0, n);
            return ans;
        }
    
        public void backtrack(List<String> ans, String cur, int open, int close, int max){
            if (cur.length() == max * 2) {
                ans.add(cur);
                return;
            }
    
            if (open < max)
                backtrack(ans, cur+"(", open+1, close, max);
            if (close < open)
                backtrack(ans, cur+")", open, close+1, max);
        }
    
}
