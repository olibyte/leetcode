import java.util.ArrayList;

class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        int[] target = new int[nums.length];
        //without using ArrayList
        // for (int i = 0; i < nums.length; i++) {
        //     target[i] = -1;
        // }

        // for (int j = 0; j < nums.length; j++) {
        //     if (target[index[j]] != -1) {
        //         for (int k = nums.length-1; k > index[j]; k--) {
        //             target[k] = target[k-1];
        //         }
        //     }
        //     target[index[j]] = nums[j];
        // }
        ArrayList<Integer> targetList = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            targetList.add(index[i], nums[i]);
        }
        for (int j = 0; j < nums.length; j++) {
            target[j] = targetList.get(j);
        }
        return target;
    }

}