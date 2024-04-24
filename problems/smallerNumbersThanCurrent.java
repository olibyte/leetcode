class smallerNumbersThanCurrent {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int result[] = new int[nums.length];
        int k = 0;
        for (int i : nums) {
            int count = 0;
            for (int j : nums) {
                if (i > j) {
                    count++;
                }
            }
            result[k++] = count;
        }
        return result;
    }
}