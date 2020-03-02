package io.github.pierceh89.leetcode;

/**
 * 155. Min Stack
 */
public class MinStack {
    Node top;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        top = null;
    }

    static class Node {
        int val;
        int minVal;
        Node next;

        Node(int v) {
            val = v;
        }
    }

    public void push(int x) {
        Node node = new Node(x);
        if (top == null) {
            node.minVal = x;
            top = node;
        } else {
            int prevMin = top.minVal;
            node.minVal = Math.min(prevMin, x);
            node.next = top;
            top = node;
        }
    }

    public void pop() {
        if (top == null) {
            throw new IllegalArgumentException("Stack is empty");
        }
        top = top.next;
    }

    public int top() {
        if (top == null) {
            throw new IllegalArgumentException("Stack is empty");
        }
        return top.val;
    }

    public int getMin() {
        return top.minVal;
    }
}
