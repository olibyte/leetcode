package interviewQuestions;

import java.util.Arrays;

public class sortColors {
    // public void sortColors(int[] nums) {
    /*
     * cheeky version, O(nlogn); Arrays.sort(nums);
     */
    // walk through nums
    public void sortColors(int[] nums) {
        if (nums == null)
            return;

        int reds = 0;
        int whites = 0;
        int blues = 0;
        for (int n : nums) {
            if (n == 0) {
                reds++;
            } else if (n == 1) {
                whites++;
            } else {
                blues++;
            }
        }
        int i = 0;
        while (reds > 0) {
            nums[i] = 0;
            i++;
            reds--;
        }
        while (whites > 0) {
            nums[i] = 1;
            i++;
            whites--;
        }
        while (blues > 0) {
            nums[i] = 2;
            i++;
            blues--;
        }
    }
}

// }
