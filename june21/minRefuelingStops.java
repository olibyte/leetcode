import java.util.PriorityQueue;

public class minRefuelingStops {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        int result = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        for (int i = 0; i <= n; i++) {
            int distance = i == n ? target : stations[i][0];
            while (startFuel < distance) {
                if (pq.size() == 0) return -1;
                startFuel += pq.poll();
                result++;
            }
            if (i < n) pq.add(stations[i][1]);
        }
        return result;
    }
}
