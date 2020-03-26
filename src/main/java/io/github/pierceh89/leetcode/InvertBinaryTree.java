package io.github.pierceh89.leetcode;

import io.github.pierceh89.ds.TreeNode;

/**
 * 226. Invert Binary Tree
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return root;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
