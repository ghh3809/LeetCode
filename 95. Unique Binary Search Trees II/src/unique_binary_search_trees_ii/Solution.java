package unique_binary_search_trees_ii;

import java.util.ArrayList;
import java.util.List;

//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<TreeNode>();
        List<List<TreeNode>> totalResult = new ArrayList<List<TreeNode>>();
        List<TreeNode> result0 = new ArrayList<TreeNode>();
        result0.add(null);
        totalResult.add(result0);
        for (int i = 1; i <= n; i ++) {
            List<TreeNode> resulti = new ArrayList<TreeNode>();
            for (int leftNum = 0; leftNum < i; leftNum ++) {
                int rightNum = i - 1 - leftNum;
                List<TreeNode> resultLeft = totalResult.get(leftNum);
                List<TreeNode> resultRight = totalResult.get(rightNum);
                for (TreeNode leftNode : resultLeft) {
                    for (TreeNode rightNode : resultRight) {
                        TreeNode root = new TreeNode(leftNum + 1);
                        root.left = addNum(leftNode, 0);
                        root.right = addNum(rightNode, leftNum + 1);
                        resulti.add(root);
                    }
                }
            }
            totalResult.add(resulti);
        }
        return totalResult.get(n);
    }
    public TreeNode addNum(TreeNode node, int num) {
        if (node == null) return null;
        TreeNode newNode = new TreeNode(node.val + num);
        if (node.left != null) newNode.left = addNum(node.left, num);
        if (node.right != null) newNode.right = addNum(node.right, num);
        return newNode;
    }
}
