package io.github.pierceh89.leetcode;

import io.github.pierceh89.ds.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 437. Path Sum III
 */
public class PathSum3 {
    public int pathSum(TreeNode root, int sum) {
        if(root == null) {
            return 0;
        }
        int[] paths = new int[1];
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            findPath(node, sum, 0, paths);
            if(node.left != null) {
                q.offer(node.left);
            }
            if(node.right != null) {
                q.offer(node.right);
            }
        }

        return paths[0];
    }

    public void findPath(TreeNode cur, int sum, int curSum, int[] count) {
        if (cur == null) {
            return;
        }

        if (sum == curSum + cur.val) {
            count[0]++;
        }
        findPath(cur.left, sum, curSum + cur.val, count);
        findPath(cur.right,sum, curSum + cur.val, count);

    }
}
