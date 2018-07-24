package de.yefan.leetcode.btree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Binary Tree Paths
 * https://leetcode.com/problems/binary-tree-paths/description/
 */
public class Num257 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root != null) {
            depthOrder(root, "", result);
        }
        return result;
    }

    private void depthOrder(TreeNode node, String path, List<String> result) {
        if (node.left == null && node.right == null) {
            result.add(path + node.val);
        }
        if (node.left != null) {
            depthOrder(node.left, path + node.val + "->", result);
        }
        if (node.right != null) {
            depthOrder(node.right, path + node.val + "->", result);
        }
    }

    public static void main(String[] args) {
        Num257 num257 = new Num257();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        TreeNode node3 = new TreeNode(5);
        node1.right = node3;
        List<String> result = num257.binaryTreePaths(root);
        System.out.println(Arrays.toString(result.toArray()));
    }
}
