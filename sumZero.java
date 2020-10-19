public class sumZero {
    public int[] sumZero(int n) {
        int result[] = new int[n];
        
        for (int i = 0; i < n-1; i+=2) {
            result[i] = i+1;
            result[i+1] = -result[i];
        }
        //5 => [1,-1,3,-3,5]
        return result;
        
    }
}
