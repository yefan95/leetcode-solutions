package de.yefan.leetcode.btree;

/**
 * Construct Binary Tree from Preorder and Inorder Traversal
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 */
public class Num105 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int pstart, int pend, int[] inorder, int istart, int iend) {
        if (pstart > pend || istart > iend) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pstart]);
        for (int i = istart; i <= iend; i++) {
            if (inorder[i] == preorder[pstart]) {
                root.left = build(preorder, pstart + 1, pstart + i - istart, inorder, istart, i - 1);
                root.right = build(preorder, pstart + i - istart + 1, pend, inorder, 1 + i, iend);
                break;
            }
        }

        return root;
    }
}
