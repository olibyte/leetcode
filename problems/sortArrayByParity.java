import java.util.ArrayList;
import java.util.List;
//A = [3,1,2,4,5]
//O = [2,4]
//E = [3,1,5]
//A = [E[0],E[1],E[2],O[0],O[1]]
public class sortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        // List<Integer> odds = new ArrayList<>();
        // List<Integer> evens = new ArrayList<>();
        // for (int i = 0; i < A.length; i++) {
        //     if (A[i] % 2 != 0) {
        //         odds.add(A[i]);
        //     }
        //     else {
        //         evens.add(A[i]);
        //     }
        // }
        // for (int j = 0; j < evens.size(); j++) {
        //     A[j] = evens.get(j);
        // }
        // int l = 0;
        // for (int k = evens.size(); k < A.length; k++) {
        //     A[k] = odds.get(l);
        //     l++;
        // }
        //  return A;
        int[] result = new int[A.length];
        int n = 0;
        //store the evens first
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                result[n] = A[i];
                n++;
            }
        }
        //then the evens, storing the result at index n onwards.
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 1) {
                result[n] = A[i];
                n++;
            }
        }
        return result;    
    }   
}
