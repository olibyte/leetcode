import java.util.ArrayList;
import java.util.List;

import javax.print.DocFlavor.STRING;

public class fizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<String>();
        for (int i = 1; i <= n; i++) {
            if ((i % 5 == 0) && (i % 3 == 0) && (i >= 5)) {
                result.add(i - 1, "FizzBuzz");
            } else if ((i % 5 == 0) && (i >= 5)) {
                result.add(i - 1, "Buzz");
            } else if ((i % 3 == 0) && (i >= 3)) {
                result.add(i - 1, "Fizz");
            } else {
                result.add(i - 1, String.valueOf(i));
            }
        }
        return result;
    }
}
