class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        // Brute force solution. Iterate fragmentSize, then starting position and sum all elements. Time O(N³)
        int sum = 0;

        for (int fragmentSize = 1; fragmentSize <= arr.length; fragmentSize += 2) {
            // summing the chunks
            for (int i = 0; i + fragmentSize <= arr.length; i++) {
                for (int j = 0; j < fragmentSize; j++)
                    sum += arr[i + j];
            }
        }
        return sum;

    }
}
// Better approach. Iterate over length and each element. Find minimum subarray starting point from left and maximum subarray starting point from right. Multiple this length and a arr[i], add this product to the answer.
// Runtime O(N²)
// class Solution {
//     public int sumOddLengthSubarrays(int[] arr) {
//         int answer = 0;
//         for (int len = 1; len <= arr.length; len += 2) {
//             for (int i = 0; i < arr.length; i++) {
//                 int left = Math.max(i - len + 1, 0);
//                 int right = Math.min(arr.length - len, i);
//                 answer += (right - left + 1) * arr[i];
//             }
//         }
        
//         return answer;
//     }
// }
// Iterate over each element in arr. Count how many subarrays exist that include this element. This half of the subarrays have odd length (in case count is odd we should divide by 2 and ceil the result)
// Runtime O(N)
// class Solution {
//     public int sumOddLengthSubarrays(int[] arr) {
//         int answer = 0;
//         for (int i = 0; i < arr.length; i++) {
//             int left = i + 1;
//             int right = arr.length - i;
            
//             int subarrays = left * right;
//             int oddSubarrays = (subarrays + 1) / 2;
            
//             answer += oddSubarrays * arr[i];
//         }
        
//         return answer;
//     }
// }

