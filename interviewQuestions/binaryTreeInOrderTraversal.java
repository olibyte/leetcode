package interviewQuestions;

import java.util.ArrayList;
import java.util.List;

//  Definition for a binary tree node.
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class binaryTreeInOrderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        walk(root, result);
        return result;
    }

    public void walk(TreeNode root, List<Integer> result) {
        if (root != null) {
            if (root.left != null) {
                // has left
                walk(root.left, result);
            }
            result.add(root.val); 
            if (root.right != null) {
                // has right
                walk(root.right, result);
            }
        }
    }
}
