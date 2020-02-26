package io.github.pierceh89.leetcode;

import io.github.pierceh89.leetcode.ds.TreeNode;

/**
 * 700. Search in a Binary Search Tree
 * Time complexity is log(n)
 */
public class SearchBST {
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode node = root;
        while(node != null) {
            if (node.val == val) {
                return node;
            }
            if (node.val < val) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        return null;
    }
}
