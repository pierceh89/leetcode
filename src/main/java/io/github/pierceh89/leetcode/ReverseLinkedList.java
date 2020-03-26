package io.github.pierceh89.leetcode;

import io.github.pierceh89.ds.ListNode;

/**
 * 206. Reverse Linked List
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
