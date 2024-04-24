class findNumbers {
    public int findNumbers(int[] nums) {
        if (nums.length == 0)
            return 0;
        int count = 0;
        for (int n : nums) {
            int digitCount = 0;
             while (n != 0) {
                digitCount++;
                 n = n/10;
            }
            if (digitCount % 2 == 0) {
                count++;
            }
        }
        return count;
    }
}