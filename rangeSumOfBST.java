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
class Solution {
    public int rangeSumBST(TreeNode root, int L, int R) {
          if (root == null) {
            return 0;
        }
        //BFS
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode current = queue.remove();
            if(current.val >= L && current.val <= R) {
                sum+= current.val;
            }
            if(current.left != null && current.val > L) {
                queue.add(current.left);
            }
            if(current.right != null && current.val < R) {
                queue.add(current.right);
            }
        }
        return sum;
    }
}