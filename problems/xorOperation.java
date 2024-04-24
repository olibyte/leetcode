class xorOperation {
    public int xorOperation(int n, int start) {
        int[] nums = new int[n];
        int bitwiseXOR  = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = start + 2*i;
            bitwiseXOR = bitwiseXOR^nums[i];
        }
        

        return bitwiseXOR;
    }
}