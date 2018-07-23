package de.yefan.leetcode.btree;

/**
 * Sum Root to Leaf Numbers
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/description/
 */


public class Num129 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public int sumNumbers(TreeNode root) {
        return sumTree(root, 0);
    }

    public int sumTree(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        return sumTree(root.left, sum) + sumTree(root.right, sum);
    }

    public static void main(String[] args) {
        Num129 num129 = new Num129();
        TreeNode root = new TreeNode(4);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(0);
        root.left = node1;
        root.right = node2;
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(1);
        node1.left = node3;
        node1.right = node4;

        int sum = num129.sumNumbers(root);
        System.out.println(sum);
    }

}
