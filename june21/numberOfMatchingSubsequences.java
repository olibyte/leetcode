import java.util.HashMap;
import java.util.Map;

public class numberOfMatchingSubsequences {
    public int numMatchingSubseq(String s, String[] words) {
    Map<String,Integer> map = new HashMap<>();
    int result = 0;
	
    for(int i = 0; i < words.length; i++) {
        String str = words[i];
        if (map.containsKey(str)) {
            if (map.get(str) == 1)
                result++;
            continue;
        } else {
            map.put(str,0);
        }
		
        int k = 0;
        boolean flag = false;
        for(int j = 0; j < str.length(); j++) {
            flag = false;
            while (k < s.length()) {
                if (s.charAt(k) == str.charAt(j)) {
                    k++;
                    flag = true;
                    break;
                }
                k++;
            }
            if (k == s.length() && !flag) {
                break;
            }
        }
        if (flag) {
            result++;
            map.put(str,1);
        }
    }
    return result;
    }
}
