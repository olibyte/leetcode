class Solution {
    public int subtractProductAndSum(int n) {
        int product = 1, sum = 0; //initialize product with value of 1 for multiplication operations
        while (n > 0) {
            sum += (n%10); //modulo 10 to 'get' the digit
            product *= (n%10);
            n /= 10; //we know we've reached the leading digit when n/10 == 0, so break the loop
        }
        return product - sum;
    }
}