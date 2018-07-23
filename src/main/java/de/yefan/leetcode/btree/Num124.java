package de.yefan.leetcode.btree;


/**
 * Binary Tree Maximum Path Sum
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
 */
public class Num124 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int maxValue = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPathDown(root);
        return maxValue;
    }

    private int maxPathDown(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));
        maxValue = Math.max(maxValue, left + right + node.val);
        return Math.max(left, right) + node.val;
    }


}
