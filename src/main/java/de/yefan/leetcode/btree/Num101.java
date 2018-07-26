package de.yefan.leetcode.btree;

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

    public boolean isSymmetric1(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        return (t1.val == t2.val) && isMirror(t1.right, t2.left) && isMirror(t1.left, t2.right);
    }

    public boolean isSymmetric2(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) {
                continue;
            }
            if (t1 == null || t2 == null) {
                return false;
            }
            if (t1.val != t2.val) {
                return false;
            }
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }

        return true;
    }
}
