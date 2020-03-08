package io.github.pierceh89.leetcode;

import io.github.pierceh89.ds.ListNode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 23. Merge k Sorted Lists
 */
class MergeKSortedLists {
        public ListNode mergeKLists(ListNode[] lists) {
            if(lists.length == 0) {
                return null;
            }
            Queue<Integer> q = new PriorityQueue<>();
            int i=0;
            int size=lists.length;
            ListNode iter=lists[i];
            while(true) {
                if (iter != null) {
                    q.offer(iter.val);
                    iter = iter.next;
                } else {
                    if (i < size-1) {
                        iter = lists[++i];
                    }
                    else {
                        break;
                    }
                }
            }
            if(q.isEmpty()) {
                return null;
            }
            ListNode ret = new ListNode(q.poll());
            ListNode cur = ret;
            while(!q.isEmpty()) {
                ListNode newNode = new ListNode(q.poll());
                cur.next = newNode;
                cur = cur.next;
            }
            return ret;
        }
}
