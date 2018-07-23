package de.yefan.leetcode.btree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Path Sum II
 * https://leetcode.com/problems/path-sum-ii/description/
 */
public class Num113 {


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(root, sum, new ArrayList<>(), res);
        return res;
    }

    private void dfs(TreeNode root, int sum, List<Integer> path, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        if (root.left == null && root.right == null && sum - root.val == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        if (root.left != null) {
            dfs(root.left, sum - root.val, path, res);
            path.remove(path.size() - 1);
        }

        if (root.right != null) {
            dfs(root.right, sum - root.val, path, res);
            path.remove(path.size() - 1);
        }
    }

    public List<List<Integer>> pathSum1(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        List<Integer> path = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        //sum along the current path
        int pathSum = 0;
        TreeNode prev = null;
        TreeNode curr = root;
        while (curr != null || !s.isEmpty()) {
            //go down all the way to the left leaf node
            //add all the left nodes to the stack
            while (curr != null) {
                s.push(curr);
                //record the current path
                path.add(curr.val);
                //record the current sum along the current path
                pathSum += curr.val;
                curr = curr.left;
            }
            //check left leaf node's right subtree
            //or check if it is not from the right subtree
            //because if is has right subtree, we don't need to push it back
            curr = s.peek();
            if (curr.right != null && curr.right != prev) {
                curr = curr.right;
                //back to the outer while loop
                continue;
            }

            if (curr.left == null && curr.right == null && pathSum == sum) {
                // why do we need new arraylist here?
                // if we are using the same path variable path
                // path will be cleared after the traversal
                list.add(new ArrayList<>(path));
            }
            // pop out the current value
            s.pop();
            prev = curr;
            // subtract current node's val from path sum
            pathSum -= curr.val;
            // as this current node is done, remove it from the current path
            path.remove(path.size() - 1);
            // reset current node to null, so check the next item from the stack
            curr = null;
        }

        return list;
    }


}
