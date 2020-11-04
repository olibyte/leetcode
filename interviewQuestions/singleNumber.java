import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class singleNumber {
    //O(n^2) - walk through nums - if nums is not in set, add. if nums is already in set, remove. the last remaining element in the set is the unique number.
    public int singleNumber(int[] nums) {
        // int unique = 0;
        Set elementSet = new HashSet(); 
        for (Integer n : nums) {
            if (elementSet.contains(n)) {
                elementSet.remove(n);
            } else {
                elementSet.add(n);
            }
        }
        return elementSet.hashCode();
    }
    //optimized using bitwise operator 
    // XOR all bits together to find unique number solution O(n) time, O(n) space
    //a XOR a = 0, a XOR 0 = a, so..
    //  a XOR b XOR a 
    //= (a XOR a) XOR b 
    //= 0 XOR b 
    //= b
    public int singleNumberOptimized(int[] nums) {
        int a = 0;

        for (int n : nums) {
            a ^= n;
        }
        return a;
    }
}