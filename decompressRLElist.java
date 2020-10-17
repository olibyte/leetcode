class decompressRLElist {
    public int[] decompressRLElist(int[] nums) {
        //iterate through nums, stepping 2 elements at a time to eval freq to calculate length of our soon to be decompressed list
        int len = 0;
        for (int i = 0; i < nums.length; i+=2) {
            len += nums[i];
        }
        //initialize decompress list, with counter to ensure val is placed at proper index in list
        int result[] = new int[len];
        int k = 0;
        for (int i = 0; i < nums.length; i+=2) {
            //use k to append val to result freq number of times
            for (int j = 0; j < nums[i]; j++) {
                result[k] = nums[i+1];
                k++;
            }
        }
        return result;
    }
}