import java.util.Map;
import java.util.TreeMap;

public class myCalendar {
    TreeMap<Integer,Integer> calendar = new TreeMap<>();
    public MyCalendar() {
        calendar.put(-1, -1);
        calendar.put(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }
    public boolean book(int start, int end) {
        Map.Entry<Integer,Integer> pairMap = calendar.higherEntry(start);
        boolean result = end <= pairMap.getValue();
        if (result) calendar.put(end, start);
        return result;
    }
}
