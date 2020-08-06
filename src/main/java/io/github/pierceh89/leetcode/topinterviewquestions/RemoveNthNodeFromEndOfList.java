package io.github.pierceh89.leetcode.topinterviewquestions;

import io.github.pierceh89.ds.ListNode;

/**
 * https://leetcode.com/explore/featured/card/top-interview-questions-easy/93/linked-list/603/
 * Remove Nth Node From End of List
 * use two pointers. before iterate pointers move j node n ahead of i.
 * when j pointer reaches the end of list, i's position is nth from end of list
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null) return head;
        ListNode i=head, j=head;
        for(int k=0; k < n; k++) {
            j = j.next;
        }
        if (j==null) {
            // when head is nth node from end of list
            head = head.next;
            return head;
        }
        for(;j.next!=null;j=j.next) {
            i=i.next;
        }
        i.next = i.next.next;
        return head;
    }
}
