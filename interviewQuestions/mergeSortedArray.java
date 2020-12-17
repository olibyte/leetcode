package interviewQuestions;

// import java.util.Arrays;

public class mergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //plop nums2 into nums1 then sort
        // for (int i = m; i < nums1.length; i++) {
        //     nums1[i] = nums2[i-m];
        // }
        // Arrays.sort(nums1);
        //two pointers, one to last element in nums2, one to last non-zero element in nums1. compare the pointers - largest goes in the slot, that pointer is decremented.
        if (nums1.length == 0 || nums2.length == 0) {
            return;
        }
        int i = m+n-1;
        // int p1 = nums1.length-1-m;
        // int p2 = nums2.length-1;
        while (m > 0 && n > 0) {
            if (nums1[m-1] > nums2[n-1]) {
                nums1[i] = nums1[m-1];
                m--;
            } else {
                nums1[i] = nums2[n-1];
                n--;
            }
            i--;
        }
        while (n > 0) {
            nums1[i] = nums2[n-1];
            n--;
            i--;
        }
    }
}
