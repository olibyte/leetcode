package interviewQuestions;

public class findFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        //linear search, O(n) time
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;

        if (nums.length < 1) {
            return result;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                result[0] = i;
                break;
            }
        }
        for (int j = nums.length -1; j >=0; j--) {
            if (nums[j] == target) {
                result[1] = j;
                break;
            }
        }
        return result;
    }
    //optimized solution using binary search. modified sub-routine.
    public int[] searchRangeOptimized(int[] nums, int target) {
        int[] targetRange = {-1, -1};

        int leftIdx = extremeInsertionIndex(nums, target, true);

        //assert leftIdx is within the array bounds and target is actually in nums

        if (leftIdx == nums.length || nums[leftIdx] != target) {
            return targetRange;
        }

        targetRange[0] = leftIdx;
        targetRange[1] = extremeInsertionIndex(nums, target, false)-1;

        return targetRange;
    }
    //helper to return leftmost of rightmost index at which target should be inserted in nums via binary search
    private int extremeInsertionIndex(int[] nums, int target, boolean left) {
        int lo = 0;
        int hi = nums.length;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > target || (left && target == nums[mid])) {
                hi = mid;
            } else {
                lo = mid+1;
            }
        }
        return lo;
    }
}
