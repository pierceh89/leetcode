package io.github.pierceh89.leetcode;

import io.github.pierceh89.leetcode.ds.TreeNode;

/**
 * 101. Symmetric Tree
 * Time Complexity is O(n)
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return compare(root.left, root.right);
    }

    public boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right ==null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }

        return (compare(left.left, right.right) &&
                compare(left.right, right.left));
    }


}
