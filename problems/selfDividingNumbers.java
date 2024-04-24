import java.util.ArrayList;
import java.util.List;

public class selfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
            for (int n = left; n <= right; ++n) {
        if (isSelfDividing(n)) 
            result.add(n);                
        }
        return result;
    }
    public boolean isSelfDividing(int n) {
        int candidate = n;
        while (candidate > 0) {
            int digit = candidate % 10; //=> 8
            candidate /= 10; //=> 12
            if (digit == 0 || (n % digit ) > 0) 
                return false;
        }
        return true;
    }
}
