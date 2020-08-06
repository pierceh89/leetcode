package io.github.pierceh89.leetcode.topinterviewquestions;

import io.github.pierceh89.ds.ListNode;

/**
 * https://leetcode.com/explore/featured/card/top-interview-questions-easy/93/linked-list/553/
 */
public class DeleteNodeInLinkedList {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
