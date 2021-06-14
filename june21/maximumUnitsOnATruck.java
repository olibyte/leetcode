import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class maximumUnitsOnATruck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b) -> b[1] - a[1]);
        int result = 0;

        for (int[] box : boxTypes) {
            int count = Math.min(box[0],truckSize);
            result += box[1] * count;
            truckSize -= count;
        }

        return result;

    }
}
