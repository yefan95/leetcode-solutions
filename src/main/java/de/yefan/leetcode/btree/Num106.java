package de.yefan.leetcode.btree;

/**
 * Construct Binary Tree from Inorder and Postorder Traversal
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 */
public class Num106 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] inorder, int istart, int iend, int[] postorder, int pstart, int pend) {
        if (istart > iend || pstart > pend) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[pend]);
        for (int i = istart; i <= iend; i++) {
            if (inorder[i] == postorder[pend]) {
                root.left = build(inorder, istart, i - 1, postorder, pstart, pstart + i - istart - 1);
                root.right = build(inorder, i + 1, iend, postorder, pstart + i - istart, pend - 1);
            }
        }

        return root;
    }


}
