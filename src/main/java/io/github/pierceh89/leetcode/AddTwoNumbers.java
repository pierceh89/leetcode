package io.github.pierceh89.leetcode;

import io.github.pierceh89.ds.ListNode;

public class AddTwoNumbers {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */

//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        int val = l1.val + l2.val;
//        int add = 0;
//        if (val >= 10) {
//            add = 1;
//            val -= 10;
//        }
//        l1 = l1.next;
//        l2 = l2.next;
//        ListNode root = new ListNode(val);
//        ListNode fol = root;
//        while(l1 != null && l2 != null) {
//            val = l1.val + l2.val + add;
//            if (val >= 10) {
//                add = 1;
//                val -= 10;
//            } else {
//                add = 0;
//            }
//            fol.next = new ListNode(val);
//            fol = fol.next;
//            l1 = l1.next;
//            l2 = l2.next;
//        }
//
//        while (l1 != null) {
//            val = l1.val + add;
//            if (val >= 10) {
//                add = 1;
//                val -= 10;
//            } else {
//                add = 0;
//            }
//            fol.next = new ListNode(val);
//            fol = fol.next;
//            l1 = l1.next;
//        }
//
//        while (l2 != null) {
//            val = l2.val + add;
//            if (val >= 10) {
//                add = 1;
//                val -= 10;
//            } else {
//                add = 0;
//            }
//            fol.next = new ListNode(val);
//            fol = fol.next;
//            l2 = l2.next;
//        }
//
//        if (add > 0) {
//            fol.next = new ListNode(add);
//        }
//
//        return root;
//    }

    // solution referred from https://github.com/qiyuangong/leetcode/blob/master/java/002_Add_Two_Numbers.java
    // this solution is shorter and easier to read.
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int pp = p != null ? p.val : 0;
            int qq = q != null ? q.val : 0;
            int val = pp + qq + carry;
            carry = val / 10;
            curr.next = new ListNode(val % 10);
            curr = curr.next;
            if(p != null) p = p.next;
            if(q != null) q = q.next;
        }

        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        return dummyHead.next;
    }

}
