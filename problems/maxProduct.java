public class maxProduct {
    public int maxProduct(int[] nums) {
               //initialise i and j to the first two elements of nums such that i is smallest of the pair
        //edgecase
        if (nums.length == 2) {
            return (nums[0]-1) * (nums[1]-1);
        }
        int biggest = 0; int secondBiggest = 0;
        if (nums[0] < nums[1]) {
            secondBiggest = nums[0];
            biggest = nums[1];
        }
        else {
            secondBiggest = nums[1];
            biggest = nums[0];
        }
        for (int k = 2; k < nums.length; k++) {
            if (nums[k] >= secondBiggest) {
                //nums[k] is now 2nd biggest or biggest
                if (nums[k] >= biggest) {
                    //nums[k] is the biggest, so currentBiggest becomes secondBiggest
                    secondBiggest = biggest;
                     biggest = nums[k];
                } else {
                    //biggest is still the biggest, but we have a new secondBiggest
                    secondBiggest = nums[k];
                }
            } 
        }
        return (biggest-1) * (secondBiggest-1);
    }
}
