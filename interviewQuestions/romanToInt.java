import java.util.HashMap;
import java.util.Hashtable;

class romanToInt {
    public int romanToInt(String s) {
        int result = 0;
        //[0-9]
        //[I,V,L,C,D,M]
        //III => 'I','I','I' => { IV? => 5-1 = 4 : IX? => 10-1 = 9 : else I*1 = 3 }
        HashMap<Character, Integer> romanIntMap = new HashMap<>();
        
        for (char c : s.toCharArray()) {
            // romanIntMap.put(s.charAt(i), ).charAt(i)
            // if (s.charAt(i) == 'I') {
                // if (s.charAt(i+1) == 'V') {
                    //4
                // } else if (s.charAt(i+1) == 'X') {
                    //9
                // } else {
                    //2 
                // }
            // }
        }
//95 
        return result;
    }
}