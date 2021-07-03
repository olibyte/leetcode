import java.util.ArrayList;
import java.util.List;

public class pascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> row, previous = null;
        for (int i = 0; i < numRows; ++i) {
            row = new ArrayList<Integer>();
            for (int j = 0; j <= i; ++j) {
                if (j ==0 || j == i) {
                    row.add(1);
                } else {
                    row.add(previous.get(j-1) + previous.get(j));
                }
            }
            previous = row;
            result.add(row);
        }
        return result;
    }
}
