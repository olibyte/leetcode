class minTimeToVisitAllPoints {
    public int minTimeToVisitAllPoints(int[][] points) {
        //O(n**2) first solution        
        int seconds = 0;

        for (int i = 0; i < points.length-1; i++)
        {
            int currentX = points[i][0];
            int currentY = points[i][1];
            int targetX = points[i+1][0];
            int targetY = points[i+1][1];
            
            while(currentX != targetX || currentY != targetY)
            {
            if (currentX < targetX)
                currentX++;
            else if (currentX > targetX)
                currentX--;
            if (currentY < targetY)
                currentY++;
            else if (currentY > targetY)
                currentY--;
            //otherwise we're in correct y
            //at this point we've done 1 move, increment seconds
            seconds++;  
            }
        }
        return seconds;
    }
}
//optimized O(n) solution, don't need the nested loop.
// class minTimeToVisitAllPoints {
//     public int minTimeToVisitAllPoints(int[][] points) {
//         int seconds = 0;

//         for (int i = 0; i < points.length - 1; i++)
//             seconds += Math.max(Math.abs(points[i][0] - points[i + 1][0]), Math.abs(points[i][1] - points[i + 1][1]));
//         return seconds;
//     }
// }