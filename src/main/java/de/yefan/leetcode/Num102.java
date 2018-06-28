package de.yefan.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Binary Tree Level Order Traversal
 * https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 */
public class Num102 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        if (root == null) {
            return resultList;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        List<Integer> list = new ArrayList<Integer>();
        TreeNode current;
        queue.add(root);
        int curLevCnt = 1;
        int nextLevCnt = 0;
        while (!queue.isEmpty()) {

            current = queue.poll();
            curLevCnt--;
            list.add(current.val);
            if (current.left != null) {
                queue.add(current.left);
                nextLevCnt++;
            }
            if (current.right != null) {
                queue.add(current.right);
                nextLevCnt++;
            }
            if (curLevCnt == 0) {
                curLevCnt = nextLevCnt;
                nextLevCnt = 0;
                resultList.add(list);
                list = new ArrayList<Integer>();
            }

        }

        return resultList;
    }
}
