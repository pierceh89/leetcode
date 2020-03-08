package io.github.pierceh89.leetcode;

import io.github.pierceh89.ds.TreeNode;

/**
 * Time Complexity if O(n)
 * Alternatively, use stack https://github.com/haoel/leetcode/blob/master/algorithms/cpp/flattenBinaryTreeToLinkedList/flattenBinaryTreeToLinkedList.cpp
 * to solve this by iterative method
 */
public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flattenRec(root);
    }

    // flatten tree and return its leaf node
    public TreeNode flattenRec(TreeNode node) {
        if (node.left == null && node.right == null) return node;
        TreeNode l = node.left;
        if (l != null) {
            TreeNode leaf = flattenRec(l);
            node.left = null;
            TreeNode r = node.right;
            node.right = l;
            if (r != null) {
                leaf.right = r;
                return flattenRec(r);
            } else {
                return leaf;
            }
        }
        TreeNode r = node.right;
        TreeNode leaf = flattenRec(r);
        return leaf;
    }
}
