package interviewQuestions;

public class moveZeroes {
    public void moveZeroes(int[] nums) {
        int lastZeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastZeroIndex] = nums[i];
                lastZeroIndex++;
            }
        }
        for (int i = lastZeroIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
