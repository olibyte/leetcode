package interviewQuestions;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class wordBreak {
    // Generic solution
    Map<String,Boolean> dictMap = new HashMap<String,Boolean>();

public boolean wordBreak(String s, List<String> wordDict) {
    if(s.isEmpty())
        return true;

    if(dictMap.containsKey(s))
        return dictMap.get(s);
    
    for(String dict: wordDict){
        if(s.startsWith(dict)){
            if(wordBreak( s.substring(dict.length()) , wordDict))
                return true;
        }
    }
    dictMap.put(s , false);
    return false;   
}
    public boolean wordBreakDFS(String s, List<String> wordDict) {
        if (s.length() == 0 || wordDict == null || wordDict.size() == 0) return false;
        
        Boolean[] memo = new Boolean[s.length() + 1];
        Set<String> wordSet = new HashSet(wordDict);
        Set<Integer> wordLenSet = new HashSet();
        for (String word : wordSet) {
            wordLenSet.add(word.length());
        }
        
        return dfs(s, 0, wordSet, wordLenSet, memo);
    }
    
    private boolean dfs(String s, int start, Set<String> wordSet, Set<Integer> wordLenSet, Boolean[] memo) {
        if (start == s.length()) return true;
        if (memo[start] != null) return memo[start];
        
        for (int wLen : wordLenSet) {
            if (start + wLen <= s.length() && 
                wordSet.contains(s.substring(start, start + wLen)) && 
                dfs(s, start+wLen, wordSet, wordLenSet, memo)) {
                return memo[start] = true;
            }
        }
        
        return memo[start] = false;
    }
    public boolean wordBreakBFS(String s, List<String> wordDict) {
        int n = s.length();
        if (n == 0 || wordDict == null || wordDict.size() == 0) return false;
        
        boolean[] added = new boolean[n+1];
        Deque<Integer> q = new ArrayDeque();
        q.offer(0);
        added[0] = true;
        
        Set<String> wordSet = new HashSet(wordDict);
        Set<Integer> wordLenSet = new HashSet();
        for (String word : wordSet) {
            wordLenSet.add(word.length());
        }
        
        while (!q.isEmpty()) {
            int start = q.poll();
            if (start == n) return true;
            for (int wLen : wordLenSet) {
                int end = start + wLen;
                if (end <= n && added[end] == false && wordSet.contains(s.substring(start, end))) {
                    q.offer(end);
                    added[end] = true;
                }
            }
        }
        
        return false;
    }
    public boolean wordBreakDP(String s, List<String> wordDict) { 
        int n = s.length();
        if (n == 0 || wordDict == null || wordDict.size() == 0) return false;
        
        boolean[] dp = new boolean[n+1];
        Set<String> wordSet = new HashSet(wordDict);
        Set<Integer> wordLenSet = new HashSet();
        for (String word : wordSet) {
            wordLenSet.add(word.length());
        }
        
        dp[0] = true;
        for (int i = 0; i <= n; i++) {
            if (dp[i] == true) {
                for (int wLen : wordLenSet) {
                    if (i+wLen <= n && wordSet.contains(s.substring(i, i+wLen))) {
                        dp[i+wLen] = true;
                    }
                }    
            }
        }
        
        return dp[n];
    }
}
