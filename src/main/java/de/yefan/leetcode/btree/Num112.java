package de.yefan.leetcode.btree;

import java.util.LinkedList;

/**
 * path sum
 * https://leetcode-cn.com/problems/path-sum/description/
 */
public class Num112 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
        LinkedList<Integer> values = new LinkedList<Integer>();

        nodes.add(root);
        values.add(root.val);

        while (!nodes.isEmpty()) {
            TreeNode curr = nodes.poll();
            int sumValue = values.poll();

            if (curr.left == null && curr.right == null && sumValue == sum) {
                return true;
            }

            if (curr.left != null) {
                nodes.add(curr.left);
                values.add(sumValue + curr.left.val);
            }

            if (curr.right != null) {
                nodes.add(curr.right);
                values.add(sumValue + curr.right.val);
            }
        }

        return false;
    }

    public boolean hasPathSum1(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && sum - root.val == 0) {
            return true;
        }
        return hasPathSum1(root.left, sum - root.val) || hasPathSum1(root.right, sum - root.val);
    }

}
