import java.util.HashMap;
import java.util.Hashtable;

class romanToInt {
    public int romanToInt(String s) {
        int result = 0;
        HashMap<Character, Integer> romanIntMap = new HashMap<>();

        romanIntMap.put('I', 1);
        romanIntMap.put('V', 5);
        romanIntMap.put('X', 10);
        romanIntMap.put('L', 50);
        romanIntMap.put('C', 100);
        romanIntMap.put('D', 500);
        romanIntMap.put('M', 1000);

        int last = Integer.MAX_VALUE;
        for (char c : s.toCharArray()) {
            if(romanIntMap.get(c) > last) {
                result += romanIntMap.get(c) - 2*last;
                last = Integer.MAX_VALUE;
            }
            else {
                result += romanIntMap.get(c);
                last = romanIntMap.get(c);
            }
        }
        return result;
    }
}