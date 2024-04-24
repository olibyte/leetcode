public class countNegativeNumbersInASortedMatrix {
    public int countNegatives(int[][] grid) {
        //edge case
        if(grid == null || grid.length == 0 ) return 0;
        //brute force, O(n^2)
        // int count = 0;
        // for (int i = 0; i < grid.length; i++) {
        //     for (int j = 0; j < grid[i].length; j++) {
        //         if (grid[i][j] < 0) {
        //             count++;
        //         }
        //     }
        // }
        //faster solution, O(n+m)
        int count = 0, row = grid.length, col = grid[0].length;
        int i = 0, j = col - 1;
        while(i < row) {
            while(j >= 0 && grid[i][j] < 0) {
                j--;
            }
            count += (col - j -1);
            i++;
        }
        return count;   
    }

}
