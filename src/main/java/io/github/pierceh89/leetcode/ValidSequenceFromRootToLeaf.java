package io.github.pierceh89.leetcode;

import io.github.pierceh89.ds.TreeNode;

/**
 * Leetcoding Challenge Week5 Day2
 */
public class ValidSequenceFromRootToLeaf {
    public boolean isValidSequence(TreeNode root, int[] arr) {
        return isValid(root, arr, 0);
    }

    public boolean isValid(TreeNode root, int[] arr, int cur) {
        if (root == null) return false;
        if (root.val != arr[cur]) return false;
        if (cur == arr.length-1) {
            // not leaf node
            return root.left == null && root.right == null;
        }
        return isValid(root.left, arr, cur+1) || isValid(root.right, arr, cur+1);
    }
}
