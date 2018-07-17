package recover_binary_search_tree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public void recoverTree(TreeNode root) {
        TreeNode current = root, prev = null, last = null;
        TreeNode err1 = null, err2 = null;
        int lastValue = Integer.MIN_VALUE;
        while (current != null) {
            
            if (current.left == null) {
                // Current node doesn't have left child, visit this node
                if (current.val < lastValue) {
                    if (err1 == null) {
                        err1 = last;
                        err2 = current;
                    } else {
                        err2 = current;
                    }
                }
                last = current;
                lastValue = current.val;
                current = current.right;
            } else {
                // Otherwise, find the prev node of current
                prev = current.left;
                while (prev.right != null && prev.right != current) prev = prev.right;
                
                if (prev.right == null) {
                    // It means we havn't visit the left child, construct a connection from prev to current
                    prev.right = current;
                    current = current.left;
                } else {
                    // Otherwise, we have visit the left child yet, now we need to visit current and then right child
                    // And do not forget to recover the tree structure -- set prev.right = null
                    prev.right = null;
                    if (current.val < lastValue) {
                        if (err1 == null) {
                            err1 = last;
                            err2 = current;
                        } else {
                            err2 = current;
                        }
                    }
                    last = current;
                    lastValue = current.val;
                    current = current.right;
                }
            }
        }
        int temp = err1.val;
        err1.val = err2.val;
        err2.val = temp;
    }
}
