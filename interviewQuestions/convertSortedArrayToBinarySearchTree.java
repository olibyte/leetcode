package interviewQuestions;

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

public class convertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return convert(nums, 0, nums.length-1);
    }
    private TreeNode convert(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end-start) / 2;
        return new TreeNode(nums[mid], convert(nums, start, mid-1), convert(nums, mid+1, end));
    }
}
