package io.github.pierceh89.leetcode;

import io.github.pierceh89.ds.ListNode;

/**
 * Time complexity is O(m + n)
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode c1 = l1, c2 = l2;
        ListNode dummyNode = new ListNode(0);
        ListNode cur = dummyNode;
        while (c1 != null && c2 != null) {
            int v1 = c1.val;
            int v2 = c2.val;
            if (v1 < v2) {
                cur.next = new ListNode(v1);
                cur = cur.next;
                c1 = c1.next;
            } else {
                cur.next = new ListNode(v2);
                cur = cur.next;
                c2 = c2.next;
            }
        }

        while (c1 != null) {
            int v1 = c1.val;
            cur.next = new ListNode(v1);
            cur = cur.next;
            c1 = c1.next;
        }

        while (c2 != null) {
            int v2 = c2.val;
            cur.next = new ListNode(v2);
            cur = cur.next;
            c2 = c2.next;
        }

        return dummyNode.next;
    }
}
