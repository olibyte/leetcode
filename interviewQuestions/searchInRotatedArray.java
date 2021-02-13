package interviewQuestions;

class SearchInRotoatedArray {
    public int search(int[] nums, int target) {
        int result = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return result;

        //binary search
        /*
        declare left and right halves
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target)
                return mid;
            // if nums[left to mid] is sorted
            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid])
                    right = mid - 1; //shrink right half
                else
                    left = mid + 1; //shrink left half
            } 
            // nums[mid to right] is sorted
            else {
                if (target > nums[mid] && target <= nums[r])
                    l = mid + 1; //shrink left
                else
                    r = mid - 1;  //shrink right
            }
        }
        return -1;
        */
    }
}