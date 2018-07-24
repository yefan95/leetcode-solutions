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

    int max = 0;

    public int longestUnivaluePath1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root, root.val);
        return max;
    }

    private int helper(TreeNode root, int val) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left, root.val);
        int right = helper(root.right, root.val);

        max = Math.max(max, left + right);
        if (root.val == val) {
            return Math.max(left, right) + 1;
        }

        return 0;
    }
}
