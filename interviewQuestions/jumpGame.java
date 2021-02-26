package interviewQuestions;

public class jumpGame {
    // backtracking
    public boolean canJump(int[] nums) {
        return canJumpFromPosition(0, nums);
    }

    private boolean canJumpFromPosition(int position, int[] nums) {
            if (position == nums.length - 1) {
                return true;
            }
    
            int furthestJump = Math.min(position + nums[position], nums.length - 1);
            for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
                if (canJumpFromPosition(nextPosition, nums)) {
                    return true;
                }
            }
            return false;
    }
}
