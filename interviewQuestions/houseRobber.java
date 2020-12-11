package interviewQuestions;

public class houseRobber {
    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        int[] runningTotal = new int[nums.length]; 
        runningTotal[0] = nums[0];
        runningTotal[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            runningTotal[i] = Math.max(runningTotal[i-2] + nums[i], runningTotal[i-1]);
        }
        return runningTotal[nums.length-1];
    }
}
