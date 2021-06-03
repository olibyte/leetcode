package june21;
public class maxAreaOfIsland {
    // char[][] grid = new char{[
    //     [0,0,1,0,0,0,0,1,0,0,0,0,0],
    //     [0,0,0,0,0,0,0,1,1,1,0,0,0],
    //     [0,1,1,0,1,0,0,0,0,0,0,0,0],
    //     [0,1,0,0,1,1,0,0,1,0,1,0,0],
    //     [0,1,0,0,1,1,0,0,1,1,1,0,0],
    //     [0,0,0,0,0,0,0,0,0,0,1,0,0],
    //     [0,0,0,0,0,0,0,1,1,1,0,0,0],
    //     [0,0,0,0,0,0,0,1,1,0,0,0,0]]}
// Output: 6
// Explanation: The answer is not 11, because the island must be connected 4-directionally.
    public int maxAreaOfIsland(int[][] grid) {
        int area = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                //if 1, and an island, increment by 1;
                if (grid[i][j] > 0) {
                    area = Math.max(area, dfs(grid,i,j));
                }
            }
        }
        return area;
    }
    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] < 1) 
            return 0;
        grid[i][j] = 0;

        return dfs(grid, i-1, j) + dfs(grid,i, j-1) + dfs(grid,i+1, j) + dfs(grid,i, j+1) + 1;
    }
}
