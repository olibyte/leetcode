public class numberOfSubarraysWithBoundedMaximum {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int result = 0; 
        int low = 0;
        int mid = 0;
        for (int num : nums) {
            if (num > right) {
                mid = 0;
            } else {
                result += ++mid;
            }
            if (num >= left) {
                low = 0;
            } else {
                result -= ++low;
            }
        }
        return result;
    }
}
