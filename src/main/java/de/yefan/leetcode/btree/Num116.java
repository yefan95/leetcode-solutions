package de.yefan.leetcode.btree;

import java.util.ArrayList;
import java.util.List;

/**
 * Populating Next Right Pointers in Each Node
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/description/
 */
public class Num116 {

    class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            root.left.next = root.right;
            if (root.next != null) {
                root.right.next = root.next.left;
            }
        }

        connect(root.left);
        connect(root.right);
    }

    public void connect1(TreeLinkNode root) {
        TreeLinkNode level_start = root;
        while (level_start != null) {
            TreeLinkNode cur = level_start;
            while (cur != null) {
                if (cur.left != null) {
                    cur.left.next = cur.right;
                }
                if (cur.right != null && cur.next != null) {
                    cur.right.next = cur.next.left;
                }

                cur = cur.next;
            }
            level_start = level_start.left;
        }
    }

    public void connect2(TreeLinkNode root) {
        helper(root, new ArrayList(), 0);
    }

    public void helper(TreeLinkNode root, List<TreeLinkNode> list, int depth) {
        if (root == null) {
            return;
        }
        if (depth == list.size()) {
            list.add(root);
        } else {
            TreeLinkNode pre = list.get(depth);
            pre.next = root;
            list.set(depth, root);
        }
        helper(root.left, list, depth + 1);
        helper(root.right, list, depth + 1);
    }
}
