package de.yefan.leetcode.btree;

import java.util.ArrayList;
import java.util.List;

/**
 * Binary Tree Preorder Traversal
 * https://leetcode.com/problems/binary-tree-preorder-traversal/description/
 */
public class Num144 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        preorder(root, list);
        return list;
    }

    private void preorder(TreeNode root, List<Integer> list) {
        if (root != null) {
            System.out.println(root.val);
            list.add(root.val);
            preorder(root.left, list);
            preorder(root.right, list);
        }
    }

}
