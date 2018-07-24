package de.yefan.leetcode.btree;

import java.util.HashMap;

/**
 * Path Sum III
 * https://leetcode.com/problems/path-sum-iii/description/
 */
public class Num437 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return findPath(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    public int findPath(TreeNode root, int sum) {
        int res = 0;
        if (root == null) {
            return res;
        }
        if (sum == root.val) {
            res++;
        }
        res += findPath(root.left, sum - root.val);
        res += findPath(root.right, sum - root.val);
        return res;
    }

    public int pathSum1(TreeNode root, int sum) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        hm.put(0, 1);
        return helper(root, sum, 0, hm);
    }

    private int helper(TreeNode root, int sum, int cur, HashMap<Integer, Integer> hm) {
        if (root == null) {
            return 0;
        }
        cur += root.val;
        int count = 0;
        if (hm.get(cur - sum) != null) {
            count += hm.get(cur - sum);
        }
        if (hm.get(cur) == null) {
            hm.put(cur, 1);
        } else {
            hm.put(cur, hm.get(cur) + 1);
        }
        count += helper(root.left, sum, cur, hm);
        count += helper(root.right, sum, cur, hm);
        hm.put(cur, hm.get(cur) - 1);
        return count;
    }
}
