class numIdenticalPairs {
    public int numIdenticalPairs(int[] nums) {
        //to do - optimize with hashmap.
        int pairs = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] == nums[j] && i < j) {
                    pairs++;
                }
            }
        }
        return pairs;
    }
}