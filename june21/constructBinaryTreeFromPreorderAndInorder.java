import java.util.HashMap;
import java.util.Map;

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
public class constructBinaryTreeFromPreorderAndInorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> M = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            M.put(inorder[i], i);
        return splitTree(preorder, inorder, M, 0, 0, inorder.length-1);
        
    }

    private TreeNode splitTree(int[] preorder, int[] inorder, Map<Integer, Integer> M, int pix, int iLeft, int iRight) {
        int rval = preorder[pix], iMid = M.get(rval);
        TreeNode root = new TreeNode(rval);            
        if (iMid > iLeft)
            root.left = splitTree(preorder, inorder, M, pix+1, iLeft, iMid-1);
        if (iMid < iRight)
            root.right = splitTree(preorder, inorder, M, pix+iMid-iLeft+1, iMid+1, iRight);
        return root;
    } 
}
