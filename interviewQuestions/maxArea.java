public class maxArea {
    public int maxArea(int[] height) {
        int capacity = 0;
        int leftWall = 0;
        int rightWall = height.length-1;
        while (leftWall < rightWall) {
            capacity = Math.max(capacity, Math.min(height[leftWall], height[rightWall]) * (rightWall - leftWall));
            if (height[leftWall] < height[rightWall]) {
                leftWall++;
            } else {
                rightWall--;
            }
        
    }
        return capacity;
    }
}
