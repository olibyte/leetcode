public class minCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        for (int i = cost.length-3; i >= 0; i--) { //starting at 3 stairs from the top
            cost[i] += Math.min(cost[i+1],cost[i+2]); //the incremental min cost will be the top stair, plus either 1 stair or 2 stairs before, whichever's smaller.
        }
        return Math.min(cost[0],cost[1]); //then return the smaller of the 2 beginning stairs.
    }
}