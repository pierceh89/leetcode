package io.github.pierceh89.leetcode;

import io.github.pierceh89.ds.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * by saving nodes in the array,
 * we can find Nth from end of list in one pass
 * Time Complexity is O(m) where m is length of nodes
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> nodes = new ArrayList<>();
        ListNode cur = head;
        while(cur != null) {
            nodes.add(cur);
            cur = cur.next;
        }
        int size = nodes.size();
        int pos = size - n;
        if (pos == 0) {
            return head.next;
        }

        if (pos+1 > size-1) {
            nodes.get(pos-1).next = null;
        } else {
            nodes.get(pos-1).next = nodes.get(pos+1);
        }
        return head;
    }
}
