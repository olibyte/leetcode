package interviewQuestions;

import java.util.ArrayList;
import java.util.List;

public class subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        
        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList();
            for (List<Integer> current : result) {
                newSubsets.add(new ArrayList<Integer>(current){{add(num);}});
            }
            for (List<Integer> current : newSubsets) {
                result.add(current);
            }
        } 
        return result;
    
    }
}
