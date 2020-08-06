package io.github.pierceh89.leetcode.topinterviewquestions;

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

    // second solution written on Aug. 6th
    // https://leetcode.com/explore/featured/card/top-interview-questions-easy/94/trees/555/
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] depth = new int[1];
        depth[0] = 0;
        maxDepth(root, 1, depth);
        return depth[0];
    }

    public void maxDepth(TreeNode node, int cur, int[] depth) {
        if(depth[0] < cur) {
            depth[0] = cur;
        }
        if(node.left != null) {
            maxDepth(node.left, cur+1, depth);
        }
        if(node.right != null) {
            maxDepth(node.right, cur+1, depth);
        }
    }
}
