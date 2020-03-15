package io.github.pierceh89.leetcode;

import io.github.pierceh89.ds.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1382. Balance a Binary Search Tree
 */
public class BalanceBST {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> arr = new ArrayList<Integer>();
        inorder(root, arr);
        int size=arr.size();
        TreeNode balancedRoot = balance(arr, 0, size-1);
        return balancedRoot;
    }

    public TreeNode balance(List<Integer> arr, int from, int to) {
        if(from > to) {
            return null;
        }
        int p = from + (to-from)/2;
        TreeNode root = new TreeNode(arr.get(p));
        root.left = balance(arr, from, p-1);
        root.right = balance(arr, p+1, to);
        return root;
    }

    public void inorder(TreeNode node, List<Integer> arr) {
        if (node == null) {
            return;
        }
        inorder(node.left, arr);
        arr.add(node.val);
        inorder(node.right, arr);
    }
}
