package de.yefan.leetcode.btree;

import java.util.*;

/**
 * Binary Tree Level Order Traversal II
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/
 */
public class Num107 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Stack<List<Integer>> stack = new Stack<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        TreeNode curr;

        queue.add(root);

        int curLevCnt = 1;
        int nextLevCnt = 0;

        while (!queue.isEmpty()) {
            curr = queue.poll();
            curLevCnt--;
            list.add(curr.val);
            if (curr.left != null) {
                queue.add(curr.left);
                nextLevCnt++;
            }
            if (curr.right != null) {
                queue.add(curr.right);
                nextLevCnt++;
            }
            if (curLevCnt == 0) {
                curLevCnt = nextLevCnt;
                nextLevCnt = 0;
                stack.add(list);
                list = new ArrayList<>();
            }
        }

        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }

    public List<List<Integer>> levelOrderBottom1(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        levelOrder(result, 0, root);

        return result;
    }

    private void levelOrder(LinkedList<List<Integer>> result, int height, TreeNode node) {
        if (node == null) {
            return;
        }

        if (result.size() <= height) {
            result.addFirst(new LinkedList<>());
        }

        result.get(result.size() - 1 - height).add(node.val);

        levelOrder(result, height + 1, node.left);
        levelOrder(result, height + 1, node.right);
    }
}
