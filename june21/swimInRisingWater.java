public class swimInRisingWater {
    int n;
    public int swimInWater(int[][] grid) {
        n = grid.length;
        boolean[][] vis = new boolean[n][n];

        int start = 0, end = n*n-1;
        while (start <= end) {
            int mid = (start+end)/2;
            if (DFS(0, 0, vis, grid, mid))
                end = mid-1;
            else
                start = mid+1;
            vis = new boolean[n][n];
        }
        return start;
    }

    private boolean DFS(int i, int j, boolean[][] vis, int[][] grid, int maxTime) {
        if (i < 0 || i >= n || j < 0 || j >= n || vis[i][j] || grid[i][j] > maxTime)
            return false;
        if (i == n-1 && j == n-1)
            return true;
        vis[i][j] = true;
        for (int x=0; x<4; x++) {
            if (DFS(i, j+1, vis, grid, maxTime))
                return true;
            if (DFS(i, j-1, vis, grid, maxTime))
                return true;
            if (DFS(i+1, j, vis, grid, maxTime))
                return true;
            if (DFS(i-1, j, vis, grid, maxTime))
                return true;
        }
        return false;
    }
}
