package de.yefan.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Symmetric Tree
 * https://leetcode.com/problems/symmetric-tree/description/
 */
public class Num101 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        boolean flag = true;
        queue.offer(root);

        while (!queue.isEmpty()) {
            int n = queue.size();
            TreeNode[] array = queue.toArray(new TreeNode[n]);
            for (int i = 0; i < n / 2; i++) {
                boolean isEqual = (array[i] == null && array[n - i - 1] != null) || (array[i] != null && array[n - i - 1] == null);
                if (array[i] != null && array[n - i - 1] != null) {
                    if (array[i].val != array[n - i - 1].val) {
                        flag = false;
                        break;
                    }
                } else if (isEqual) {
                    flag = false;
                }
            }

            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                } else {
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
            if (!flag) {
                break;
            }
        }
        return flag;
    }
}
