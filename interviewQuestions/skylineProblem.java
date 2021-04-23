package interviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class skylineProblem {
    public List<List<Integer>> getSkyline(int[][] buildings) {

        Arrays.sort(buildings, (a, b) -> {
            if (a[0] != b[0])
                return a[0] - b[0];
            // this is important, sort reverse by height
            return b[2] - a[2];
        });

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        List<List<Integer>> ans = new ArrayList<>();

        for (var building : buildings) {
            if (pq.isEmpty()) {
                pq.add(building);
                ans.add(List.of(building[0], building[2]));
                continue;
            }

            while (!pq.isEmpty() && building[0] > pq.element()[1]) {
                var removed = pq.remove();
                while (!pq.isEmpty() && pq.element()[1] <= removed[1]) {
                    pq.remove();
                }
                ans.add(List.of(removed[1], pq.isEmpty() ? 0 : pq.element()[2]));
            }

            if (pq.isEmpty() || pq.element()[2] < building[2]) {
                ans.add(List.of(building[0], building[2]));
            }
            // remove the same height overlaps
            while (!pq.isEmpty() && pq.element()[2] == building[2] && pq.element()[1] >= building[0]
                    && pq.element()[1] < building[1]) {
                pq.remove();
            }
            pq.add(building);
        }

        while (!pq.isEmpty()) {
            var removed = pq.remove();
            while (!pq.isEmpty() && pq.element()[1] <= removed[1]) {
                pq.remove();
            }
            ans.add(List.of(removed[1], pq.isEmpty() ? 0 : pq.element()[2]));
        }

        return ans;
    }
}
