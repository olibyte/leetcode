package interviewQuestions;

import java.util.ArrayList;
import java.util.List;

public class permutations {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> res= new ArrayList<>();
            List<Integer> curr= new ArrayList<>();
            boolean[] visited= new boolean[nums.length];
            permutations(nums, visited, res, curr);
            return res;
        }
        public void permutations(int[] nums, boolean[] visited, List<List<Integer>> res, List<Integer> curr){
            if(curr.size()==nums.length){
                res.add(new ArrayList(curr));
                return;
            }
            for(int i=0;i<nums.length;i++){
                if(!visited[i]){
                    visited[i]=true;
                    curr.add(nums[i]);
                    permutations(nums, visited, res, curr);
                    curr.remove(curr.size()-1);
                    visited[i]=false;    
                }
            }
        }
    }    
}