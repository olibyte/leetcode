package interviewQuestions;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class maxDepth {
    public int maxDepth(TreeNode root) {
        //tree is empty
        if (root == null) {
            return 0;
        } else {
            //compute depths
            int lDepth = root.left;
            int rDepth = root.right;
            //follow the larger/deeper subtree
            if (lDepth > rDepth) {
                return (lDepth + 1);
            } else {
                return (rDepth + 1);
            }
        }
    }
}
