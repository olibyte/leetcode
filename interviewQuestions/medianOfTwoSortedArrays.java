import java.util.ArrayList;

public class medianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int totalLength = (m+n);
        double medianIndex = Math.floor(totalLength)/2;
        int prev = 0,curr = 0,i = 0,j = 0,count = 0;
        while(count <= medianIndex){
            count++;
            prev = curr;
                if((i < m && j < n && nums1[i] > nums2[j]) || (i >= m && j < n)){
                    curr = nums2[j];
                    j++;
                    continue;
                }if((i < m && j < n && nums1[i] <= nums2[j]) || (i < m && j >= n)){
                     curr = nums1[i];
                     i++;
                    continue;
                }   
        }
        if((m+n)%2 != 0)
            return curr;
        else
            return ((double)(prev+curr)/2);
    }
}
//optimized https://leetcode.com/problems/median-of-two-sorted-arrays/solution/
class Solution {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j-1] > A[i]){
                iMin = i + 1; // i is too small
            }
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = i - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}