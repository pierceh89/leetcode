package io.github.pierceh89.leetcode;

import io.github.pierceh89.ds.TreeNode;

/**
 * Leetcoding Challenge Week5 Day1
 */
public class BinaryTreeMaximumPathSum {
    public int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        if(root != null) {
            maxPath(root, max);
        }
        return max[0];
    }
    public void maxPath(TreeNode root, int[] max) {
        int current = root.val;
        max[0] = Math.max(max[0], current);
        if (root.right!=null){
            maxPath(root.right, max);
            root.val = Math.max(root.val, current+root.right.val);
            max[0] = Math.max(max[0], current+root.right.val);
        }
        if (root.left!=null) {
            maxPath(root.left, max);
            root.val = Math.max(root.val, current+root.left.val);
            max[0] = Math.max(max[0], current+root.left.val);
        }
        if (root.right!=null && root.left!=null){
            max[0] = Math.max(max[0], current+root.left.val+root.right.val);
        }
    }
}
