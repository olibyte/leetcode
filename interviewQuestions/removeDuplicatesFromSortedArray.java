package interviewQuestions;

public class removeDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return 1;
        int slow = 0;
        //shift all the unique elements to the front of the array using two pointers, fast and slow
        for (int fast = 1; fast < nums.length; fast++) {
            //if we've found a unique element, shift it to the next slot
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }
        //slow counts the number of slots for unique elements, so we return slow + 1
        return slow+1;
    }
}
