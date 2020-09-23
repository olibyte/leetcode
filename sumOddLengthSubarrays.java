class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        int fragmentSize = 0;
        boolean canPartition  = fragmentSize <= arr.length;
        while  (canPartition) {
            //walk through the array
            for (int i = 0; i < arr.length - fragmentSize; i++) {
                //summing the chunks
                for (int j = i; j <= fragmentSize; j++){
                    sum += arr[j];
                }
            }
            fragmentSize += 2;
        }
        //sum the subarrays of length 1, fragmentSize = 0
        for (int i = 0; i < arr.length - fragmentSize; i++) {
            sum += arr[i]; 
        }
        
        //sum the subarrays of length 3, fragmentSize = 2
        for (int i = 0; i < arr.length - fragmentSize; i++) {
            //sum the chunks
            for (int j = i; j <= fragmentSize; j++){
                sum += arr[i+j];
            }
            fragmentSize+= 2;
        }
        //sum the sub, fragmentsize = 4
        for (int i = 0; i < arr.length - fragmentSize; i++) {
            for (int j = i; j < fragmentSize; j++)
            sum+= arr[i+j];
        }
    }
}