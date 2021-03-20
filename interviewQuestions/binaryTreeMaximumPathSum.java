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
class binaryTreeMaximumPathSum {
    int result = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maximumUtility(root);
            return result;
    }
    public int maximumUtility(TreeNode root) {
        if (root == null)
            return 0;
            //stores max path sum of left and right subtree
        int left = maximumUtility(root.left);
        int right = maximumUtility(root.right);
        //case 1 current node lies in the path of maximumPathSum
        int candidate1 = Math.max(Math.max(left,right) + root.val, root.val);
        //case 2 current node is the root of maximumPathSum
        int candidate2 = Math.max(candidate1, left+right+root.val);
        //case 3 current node does not lie in maximumPathSum
        result = Math.max(candidate2, result);

        return candidate1;
    }
}