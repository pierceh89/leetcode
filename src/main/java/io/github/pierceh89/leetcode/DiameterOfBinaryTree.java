package io.github.pierceh89.leetcode;

import io.github.pierceh89.ds.TreeNode;

/**
 * 543. Diameter of Binary Tree
 * https://leetcode.com/problems/diameter-of-binary-tree/discuss/101130/C%2B%2B-Java-Clean-Code
 */
public class DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] diameter = new int[1];
        longestPath(root, diameter);

        return diameter[0];
    }

    public int longestPath(TreeNode node, int[] diameter) {
        if(node == null) {
            return 0;
        }
        int left = longestPath(node.left, diameter);
        int right = longestPath(node.right, diameter);
        diameter[0] = Math.max(diameter[0], left+right);
        return 1 + Math.max(left, right);
    }
}
