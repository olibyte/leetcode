class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] shuffled = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            shuffled[i] = (i % 2 == 0) ? nums[i / 2] : nums[i / 2 + n];
        }
        return shuffled;
    }
}