package io.github.pierceh89.leetcode;

import io.github.pierceh89.ds.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * preOrder traverse tree with LinkedHashMap
 * so that it keeps the sequence of nodes
 * Space Complexity O(n)
 * Time Complexity O(n)
 *
 * Using Queue(https://github.com/haoel/leetcode/blob/master/algorithms/java/src/binaryTreeLevelOrderTraversal/binaryTreeLevelOrderTraversal.java)
 * is slightly faster since it does not need transformation from map of list to list of list.
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Map<Integer, List<Integer>> map = new LinkedHashMap<>();
        preOrder(root, map, 0);
        return map.keySet().stream().map(it -> map.get(it)).collect(Collectors.toList());
    }

    public void preOrder(TreeNode start, Map<Integer, List<Integer>> map, int lv) {
        if (start == null) {
            return;
        }
        if (map.containsKey(lv)) {
            map.get(lv).add(start.val);
        } else {
            List<Integer> nodes = new ArrayList<>();
            nodes.add(start.val);
            map.put(lv, nodes);
        }
        if (start.left != null) {
            preOrder(start.left, map, lv+1);
        }
        if (start.right != null) {
            preOrder(start.right, map, lv+1);
        }
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> solution = new ArrayList<>();
        if (root == null) {
            return solution;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        // add throws NPE if element is null
        queue.offer(root);
        queue.offer(null);
        List<Integer> values = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                // null is level identifier
                solution.add(new ArrayList<>(values));
                values.clear();

                if (queue.isEmpty()) {
                    break;
                }
                queue.offer(null);
                continue;
            }
            values.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        return solution;
    }
}
