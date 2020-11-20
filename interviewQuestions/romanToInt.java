import java.util.HashMap;
import java.util.Hashtable;

class romanToInt {
    public int romanToInt(String s) {
        int result = 0;
        //[0-9]
        //[I,V,L,C,D,M]
        //III => 'I','I','I' => { IV? => 5-1 = 4 : IX? => 10-1 = 9 : else I*1 = 3 }
        HashMap<Character, Integer> romanIntMap = new HashMap<>();
        
            //perform roman to int
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