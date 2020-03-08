package io.github.pierceh89.leetcode;

import io.github.pierceh89.ds.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        boolean fromLeft = true;
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> q = new LinkedList<>();
        q.offerLast(root);
        q.offerLast(null);
        List<Integer> sublist = new ArrayList<>();
        while(!q.isEmpty()) {
            TreeNode node;
            if (fromLeft) {
                node = q.pollFirst();
            } else {
                node = q.pollLast();
            }
            if (node == null) {
                result.add(new ArrayList<>(sublist));
                sublist.clear();

                if (q.isEmpty()) {
                    break;
                }

                fromLeft = !fromLeft;
                if (fromLeft) {
                    q.offerLast(null);
                } else {
                    q.offerFirst(null);
                }
                continue;
            }
            sublist.add(node.val);
            if (fromLeft) {
                if (node.left != null) {
                    q.offerLast(node.left);
                }
                if (node.right != null) {
                    q.offerLast(node.right);
                }
            } else {
                if (node.right != null) {
                    q.offerFirst(node.right);
                }
                if (node.left != null) {
                    q.offerFirst(node.left);
                }

            }
        }
        return result;
    }
}
