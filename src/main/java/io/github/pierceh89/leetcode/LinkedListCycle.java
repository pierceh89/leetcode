package io.github.pierceh89.leetcode;

import io.github.pierceh89.leetcode.ds.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 141. Linked List Cycle
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        ListNode cur = head;
        while(cur != null) {
            if (visited.contains(cur)) {
                return true;
            }
            visited.add(cur);
            cur = cur.next;
        }
        return false;
    }
    // slow pointer (step one) and fast pointer (step two)
    public boolean hasCycleTwoPointer(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != slow) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
