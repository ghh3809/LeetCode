package validate_binary_search_tree;


//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean isValid(TreeNode root, long min, long max) {
        long value = (long)root.val;
        if ((value <= min) || (value >= max)) return false;
        if ((root.left  != null) && ((root.left.val  >= root.val) || (!isValid(root.left,  min, value))) ||
            (root.right != null) && ((root.right.val <= root.val) || (!isValid(root.right, value, max))))
            return false;
        return true;
    }
}
