package interviewQuestions;

class maximumProductSubarray {
    public int maxProduct(int[] nums) {

        if (nums.length == 0) return 0;
        
        int res = nums[0];
        int positive = 1;
        int negative = 1;
        
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (x >= 0) {
                positive = Math.max(positive * x, x);
                negative = negative * x;
            } else {
                int tmp = negative;
                negative = Math.min(positive * x, x);
                positive = tmp * x;
            }
            res = Math.max(res,positive);
            res = Math.max(res,negative);
        }
        return res;
    }
}
