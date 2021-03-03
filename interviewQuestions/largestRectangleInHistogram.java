package interviewQuestions;

import java.util.Stack;

public class largestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
//geeksforgeeks.org/largest-rectangle-under-histogram/
/*
        int len = heights.length;
        Stack<Integer> s = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i <= len; i++){
            int h = (i == len ? 0 : heights[i]);
            if (s.isEmpty() || h >= heights[s.peek()]) {
                s.push(i);
            } else {
                int tp = s.pop();
                maxArea = Math.max(maxArea, heights[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }
        }
        return maxArea;
        */
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int[] lessFromLeft = new int[heights.length]; // idx of the first bar the left that is lower than current
        int[] lessFromRight = new int[heights.length]; // idx of the first bar the right that is lower than current
        lessFromRight[heights.length - 1] = heights.length;
        lessFromLeft[0] = -1;
    
        for (int i = 1; i < heights.length; i++) {
            int p = i - 1;
    
            while (p >= 0 && heights[p] >= heights[i]) {
                p = lessFromLeft[p];
            }
            lessFromLeft[i] = p;
        }
    
        for (int i = heights.length - 2; i >= 0; i--) {
            int p = i + 1;
    
            while (p < heights.length && heights[p] >= heights[i]) {
                p = lessFromRight[p];
            }
            lessFromRight[i] = p;
        }
    
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            maxArea = Math.max(maxArea, heights[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
        }
    
        return maxArea;
    }
}
