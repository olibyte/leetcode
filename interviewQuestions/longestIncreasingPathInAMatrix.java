public class longestIncreasingPathInAMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
         int m = matrix[0].length;
         boolean[][] visited = new boolean[n][m];
         int[][] dp = new int[n][m];
         for(int i = 0; i < n; i++) Arrays.fill(dp[i],-1);
         
         int maxlen = 0;
         for(int i = 0; i < n; i++){
             for(int j = 0; j < m ; j++){
                 maxlen = Math.max(maxlen,DFS(matrix, i, j, visited,dp));
             }
         }
         return maxlen;
     }
     
     public int DFS(int[][] matrix, int i, int j, boolean[][] visited, int[][] dp){
         if(dp[i][j] != -1) return dp[i][j];
         
         visited[i][j] = true;
         int maxlen = 0;
          int[][] dir ={{-1,0},{1,0},{0,-1},{0,1}};
         
         for(int d = 0; d < dir.length; d++){
             int x = i + dir[d][0];
             int y = j + dir[d][1];
             
             if(x<matrix.length && x>=0 && y < matrix[0].length && y>=0 && !visited[x][y]){
                 if(matrix[x][y] > matrix[i][j]){
                     maxlen =  Math.max(maxlen,DFS(matrix, x, y, visited,dp));   
                 }
             }
         }
     
         visited[i][j] = false;
         
         dp[i][j] = maxlen+1;
         
         return maxlen+1;
     }     
}
