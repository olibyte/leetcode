import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class countOfSmallerNumbersAfterSelf {
    
    public List<Integer> countSmaller(int[] nums) {

       // Base case
       if (nums == null || nums.length == 0) {
        return List.of();
    }

    int n = nums.length;

    // After custom merge sort's run completes it will contains final result count
    int[] result = new int[n];

    ElementWithIndex[] elementWithIndices = new ElementWithIndex[n];

    for (int i = 0; i < n; i++) {
        elementWithIndices[i] = new ElementWithIndex(nums[i], i);
    }

    customMergeSort(elementWithIndices, 0, n - 1, result);

    return Arrays.stream(result).boxed().collect(Collectors.toList());
}

private void customMergeSort(ElementWithIndex[] elementWithIndices, int start, int end, int[] result) {
    if (start >= end) {
        return;
    }

    int mid = (start + end) / 2;

    // Recursive call for left sub array
    customMergeSort(elementWithIndices, start, mid, result);

    // Recursive call for right sub array
    customMergeSort(elementWithIndices, mid + 1, end, result);

    int leftPointer = start;
    int rightPointer = mid + 1;

    List<ElementWithIndex> mergedArray = new LinkedList<>();

    int numberOfElementsInRightArrayLessThanLeftArray = 0;

    while (leftPointer < mid + 1 && rightPointer <= end) {

        // Left sub array's element is greater than right sub array's element
        if (elementWithIndices[leftPointer].value > elementWithIndices[rightPointer].value) {

            // Increment the counter
            numberOfElementsInRightArrayLessThanLeftArray++;

            // Add element at rightPointer to mergedArray list
            mergedArray.add(elementWithIndices[rightPointer]);

            // Increment right pointer
            rightPointer++;
        } else {
            // Left sub array's element is smaller than right sub array's element
            // Update result with count
            result[elementWithIndices[leftPointer].index] += numberOfElementsInRightArrayLessThanLeftArray;

            // Add element at leftPointer to mergedArray list
            mergedArray.add(elementWithIndices[leftPointer]);

            // Increment left pointer
            leftPointer++;
        }
    }

    // Similar to normal merge sort iterate through remaining left subarray and right subarray
    while (leftPointer < mid + 1) {
        result[elementWithIndices[leftPointer].index] += numberOfElementsInRightArrayLessThanLeftArray;

        // Add element at leftPointer to mergedArray list
        mergedArray.add(elementWithIndices[leftPointer]);

        // Increment left pointer
        leftPointer++;
    }

    while (rightPointer <= end) {
        // Add element at rightPointer to mergedArray list
        mergedArray.add(elementWithIndices[rightPointer]);

        // Increment right pointer
        rightPointer++;
    }

    // Similar to normal merge sort copy back merged result into array
    int pos = start;
    for (ElementWithIndex elementWithIndex : mergedArray) {
        elementWithIndices[pos] = elementWithIndex;
        ++pos;
    }

}

private static class ElementWithIndex {
    int value;

    int index;

    public ElementWithIndex(int value, int index) {
        this.value = value;
        this.index = index;
    }
}
}