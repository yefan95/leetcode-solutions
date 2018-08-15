package de.yefan.leetcode.dynamicprogramming;

/**
 * House Robber III
 * https://leetcode.com/problems/house-robber-iii/description/
 */
public class Num337 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }

    public int rob(TreeNode root) {
        int[] maxVal = helper(root);

        return Math.max(maxVal[0], maxVal[1]);
    }

    private int[] helper(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        } else {
            //maxVal[0] store the max value without robing current node
            // maxVal[1] store the max value with robing current node
            int[] maxVal = new int[2];
            int[] leftMax = helper(root.left);
            int[] rightMax = helper(root.right);

            maxVal[0] = Math.max(leftMax[0], leftMax[1]) + Math.max(rightMax[0], rightMax[1]);
            maxVal[1] = leftMax[0] + rightMax[0] + root.val;

            return maxVal;
        }
    }
}
