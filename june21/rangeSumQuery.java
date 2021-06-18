public class rangeSumQuery {
    class SegmentTreeNode {
        private int start, end;
        private SegmentTreeNode left, right;
        private int sum;

        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
            this.sum = 0;
        }
    }
    SegmentTreeNode root = null;

    public NumArray(int[] nums) {
        root = buildTree(nums,0,nums.length-1);    
    }
    
    private SegmentTreeNode buildTree(int[] nums, int start, int end) {
        if (start > end)
            return null;
        else {
            SegmentTreeNode result = new SegmentTreeNode(start, end);
            if (start == end) {
                result.sum = nums[start];
            } else {
                int mid = start + (end - start) / 2;
                result.left = buildTree(nums, start, mid);
                result.right = buildTree(nums, mid+1, end);
                result.sum = result.left.sum + result.right.sum;
            }
            return result;
        }
    }

    public void update(int index, int val) {
        updateHelper(root, index, val);
    }
    
    private void updateHelper(SegmentTreeNode root, int pos, int val) {
        if (root.start == root.end) {
            root.sum = val;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            if (pos <= mid) {
                updateHelper(root.left, pos, val);
            } else {
                updateHelper(root.right, pos, val);
            }
            root.sum = root.left.sum + root.right.sum;
        }
    }

    public int sumRange(int left, int right) {
        return sumRangeHelper(root, left, right);   
    }

    private int sumRangeHelper(SegmentTreeNode root, int start, int end) {
        if (root.start == start && root.end == end) {
            return root.sum;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            if (end <= mid) {
                return sumRangeHelper(root.left, start, end);
            } else if (start >= mid+1) {
                return sumRangeHelper(root.right, start, end);
            } else {
                return sumRangeHelper(root.left, start, mid) + sumRangeHelper(root.right, mid+1, end);
            }
        }
    }
}
