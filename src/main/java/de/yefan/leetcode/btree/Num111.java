package de.yefan.leetcode.btree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Minimum Depth of Binary Tree
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/description/
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Num111 {


    public int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int l = minDepth(root.left);

        int r = minDepth(root.right);

        if (l == 0 || r == 0) {
            return l + r + 1;
        }

        return Math.min(l, r) + 1;
    }

    public int minDepth1(TreeNode root) {

        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        int depth = 1;

        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            depth++;
        }

        return depth;
    }

    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        if (root.left == null || root.right == null) {
            return Math.max(minDepth2(root.left), minDepth2(root.right)) + 1;
        }

        return Math.min(minDepth2(root.left), minDepth2(root.right)) + 1;
    }


    public static void main(String[] args) {
        Num111 num111 = new Num111();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        node1.left = node3;
        node1.right = node4;
        int depth = num111.minDepth1(root);
        System.out.println(depth);
    }

}
