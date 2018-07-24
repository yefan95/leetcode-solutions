package de.yefan.leetcode.btree;

import java.util.ArrayList;
import java.util.List;

/**
 * Binary Tree Inorder Traversal
 * https://leetcode.com/problems/binary-tree-inorder-traversal/description/
 */
public class Num94 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        inorder(root, list);
        return list;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root != null) {
            inorder(root.left, list);
            list.add(root.val);
            inorder(root.right, list);
        }
    }
}
