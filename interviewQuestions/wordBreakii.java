package interviewQuestions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class wordBreakii {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for(String word: wordDict) {
            set.add(word);
        }
        
        List<String> res = new ArrayList<>();
        helper(s, 0, set, new StringBuilder(), res);
        return res;
    }
    
    private void helper(String s, int start, Set<String> set, StringBuilder sb, List<String> res) {
        if(start == s.length()) {
            sb.setLength(sb.length() - 1);
            res.add(sb.toString());
            return;
        }
        
        for(int i = start; i < s.length(); ++i) {
            String str = s.substring(start, i + 1);
            if(set.contains(str)) {
                int len = sb.length();
                sb.append(str);
                sb.append(" ");
                helper(s, i + 1, set, sb, res);
                sb.setLength(len);
            }
        }
    }
}
