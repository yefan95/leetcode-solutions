package de.yefan.leetcode.btree;

/**
 * Longest Univalue Path
 * https://leetcode.com/problems/longest-univalue-path/description/
 */
public class Num687 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int sameNodeValue(TreeNode node, int[] res) {
        int l = node.left != null ? sameNodeValue(node.left, res) : 0;
        int r = node.right != null ? sameNodeValue(node.right, res) : 0;
        int resl = node.left != null && node.left.val == node.val ? l + 1 : 0;
        int resr = node.right != null && node.right.val == node.val ? r + 1 : 0;
        res[0] = Math.max(res[0], resl + resr);
        return Math.max(resl, resr);
    }

    public int longestUnivaluePath(TreeNode root) {
        int[] res = new int[1];
        if (root != null) {
            sameNodeValue(root, res);
        }
        return res[0];
    }
}
