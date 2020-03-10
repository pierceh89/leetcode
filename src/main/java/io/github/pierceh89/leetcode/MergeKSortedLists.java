package io.github.pierceh89.leetcode;

import io.github.pierceh89.ds.ListNode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 23. Merge k Sorted Lists
 * Time Complexity is O(nlogk) where n is the total number of ListNode and k is the length of lists
 * Space Complexity O(k)
 */
class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        Queue<ListNode> q = new PriorityQueue<>(lists.length, (v1, v2) -> {
            if (v1.val < v2.val) {
                return -1;
            } else if (v1.val == v2.val) {
                return 0;
            } else {
                return 1;
            }
        });
        for (ListNode list : lists) {
            if (list != null) {
                q.offer(list);
            }
        }
        if (q.isEmpty()) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (!q.isEmpty()) {
            ListNode node = q.poll();
            tail.next = node;
            tail = tail.next;
            if (node.next != null) {
                q.offer(node.next);
            }
        }
        return dummy.next;
    }
}
