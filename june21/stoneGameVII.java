public class stoneGameVII {
    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        int[] dpCurr = new int[n];
        int[] dpLast = new int[n];
        for (int left = n - 2; left >= 0; left--) {
            int total = stones[left];
            int[] temp = dpLast;
            dpLast = dpCurr;
            dpCurr = temp;
            for (int right = left + 1; right < n; right++) {
                total += stones[right];
                dpCurr[right] = Math.max(total - stones[left] - dpLast[right], total - stones[right] - dpCurr[right-1]);
            }
        }
        return dpCurr[n-1];
    }
}
