package io.github.pierceh89.leetcode;

import io.github.pierceh89.ds.ListNode;

/**
 * 876. Middle of the Linked List
 */
public class MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        if(head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if(fast == null) {
            return slow;
        }
        return slow.next;
    }
}
