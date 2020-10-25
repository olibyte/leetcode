public class maxDepth {
    public int maxDepth(String s) {
        //!= "(" || != ")"
        int parenthesisCount = 0;
        int maxDepth = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                parenthesisCount++;
                maxDepth = Math.max(maxDepth,parenthesisCount);
            }
            if (s.charAt(i) == ')') {
                parenthesisCount--;
            }
        }
        return maxDepth;
    }
}
