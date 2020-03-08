package io.github.pierceh89.leetcode;

import io.github.pierceh89.ds.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderIter(root, result);
        return result;
    }

    public void inorder(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        if(node.left != null) {
            inorder(node.left, result);
        }
        result.add(node.val);
        if(node.right != null) {
            inorder(node.right, result);
        }

    }

    public void inorderIter(TreeNode node, List<Integer> result) {
        TreeNode cur = node;
        Stack<TreeNode> s = new Stack<>();
        while(cur != null || !s.empty()) {
            while (cur != null) {
                s.push(cur);
                cur = cur.left;
            }
            cur = s.pop();
            result.add(cur.val);

            cur = cur.right;
        }
    }
}
