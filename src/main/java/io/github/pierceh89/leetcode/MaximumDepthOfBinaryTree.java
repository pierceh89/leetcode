package io.github.pierceh89.leetcode;

import io.github.pierceh89.ds.TreeNode;

class MaximumDepthOfBinaryTree {
	public int maxDepth(TreeNode root) {
        return maxDepth(root, 1);
    }
    
    public int maxDepth(TreeNode node, int depth) {
        if (node == null) {
            return depth-1;
        }
        if (node.left == null && node.right == null) {
            return depth;
        }
        return Math.max(maxDepth(node.left, depth+1), maxDepth(node.right, depth+1));
        
    }
}
