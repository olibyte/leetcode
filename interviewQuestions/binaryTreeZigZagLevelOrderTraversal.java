package interviewQuestions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


// Definition for a binary tree node.
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class binaryTreeZigZagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> myQueue = new LinkedList<>();
        int level =0;
        myQueue.add(root);
        
        while (myQueue.size() > 0){
            LinkedList<Integer> levelList = new LinkedList<Integer>();
            int size = myQueue.size();
            
			//Traverse level by level up to size of the level
            for(int i = 0;i < size; i++){
                var node = myQueue.poll();
				
				//process the result in ZigZagging manner using linked list
                if (level % 2 == 0) {
                    levelList.addLast(node.val);
                }
                else {
                    levelList.addFirst(node.val);
                }
                if (node.left != null)
                {
                    myQueue.add(node.left);
                }
                if (node.right != null)
                {
                    myQueue.add(node.right);
                }
            }
            result.add(levelList); // Note: Convert the linked list to plain list depends on language you use
            level++;
        }
        return result;        
    }    
}
