package io.github.pierceh89.leetcode;

import io.github.pierceh89.leetcode.ds.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 160. Intersection of Two Linked Lists
 * Time Complexity in worst case O(a+b) if the last node is the intersection
 * Space Complexity O(a) or O(b)
 * where a and b are length of list A and B respectively.
 */
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> map = new HashSet<>();
        // put nodes in A first
        ListNode curA = headA;
        while(curA != null) {
            map.add(curA);
            curA = curA.next;
        }

        ListNode curB = headB;
        while(curB != null) {
            if (map.contains(curB)) {
                return curB;
            }
            curB = curB.next;
        }
        return null;
    }

    // using two pointers
    public ListNode getIntersectionNodeTwoPointers(ListNode headA, ListNode headB) {
        ListNode curA=headA, curB=headB;
        while(curA != curB) {
            curA = (curA != null) ? curA.next : headB;
            curB = (curB != null) ? curB.next : headA;
        }
        return curA;
    }
}
