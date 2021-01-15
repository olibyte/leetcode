package interviewQuestions;

public class kthLargestElementInArray {
    private int size = 0;

    public int findKthLargest(int[] nums, int k) {
        /*
         * //Cheeky version. O(nlogn) time, O(1) space Arrays.sort(nums); return
         * nums[nums.length-k];
         **/
        // heap implementation
        size = nums.length;

        heapify(nums);

        for (int i = 0; i < k - 1; i++)
            delete(nums);
        return nums[0];
    }

    void heapify(int[] nums) {
        for (int i = size / 2 - 1; i >= 0; i--) {
            percolateDown(nums, i);
        }
    }

    void delete(int nums[]) {
        nums[0] = nums[size - 1];
        size--;
        percolateDown(nums, 0);
    }

    void percolateDown(int nums[], int index) {
        while (index < size) {
            int max = index;
            if (getLeft(index) != -1 && nums[getLeft(index)] > nums[max])
                max = getLeft(index);
            if (getRight(index) != -1 && nums[getRight(index)] > nums[max])
                max = getRight(index);

            if (max != index) {
                swap(max, index, nums);
                index = max;
            } else
                break;
        }
    }

    void swap(int indexA, int indexB, int arr[]) {
        int temp = arr[indexB];
        arr[indexB] = arr[indexA];
        arr[indexA] = temp;
    }

    int getLeft(int index) {
        return (index * 2 + 1) >= size ? -1 : (index * 2 + 1);
    }

    int getRight(int index) {
        return (index * 2 + 2) >= size ? -1 : (index * 2 + 2);
    }
}
