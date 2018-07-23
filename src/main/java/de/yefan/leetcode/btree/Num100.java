package de.yefan.leetcode.btree;

/**
 * Same Tree
 * https://leetcode.com/problems/same-tree/description/
 */
public class Num100 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p != null && q != null) {
            if (p.val == q.val) {
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            } else {
                return false;
            }
        }
        if (p == null && q == null) {
            return true;
        } else {
            return false;
        }
    }

}
