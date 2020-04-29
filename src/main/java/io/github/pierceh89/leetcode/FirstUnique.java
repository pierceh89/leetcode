package io.github.pierceh89.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcoding Challenge Week4 Day7
 */
class FirstUnique {

    static class DNode {
        int value;
        DNode prev,next;
        DNode(int v) {
            value = v;
            prev = next = null;
        }
    }
    Map<Integer, DNode> map = new HashMap<>();
    DNode head, tail;

    public FirstUnique(int[] nums) {
        head = new DNode(0);
        tail = head;
        for(int val : nums) {
            if(map.containsKey(val)) {
                DNode node = map.get(val);
                if(node != null) {
                    remove(node);
                    map.put(val, null);
                }
            } else {
                add(val);
            }
        }
        //System.out.print("init: ");
        //print(head.next);
    }

    public int showFirstUnique() {
        if (head.next != null) {
            return head.next.value;
        }
        return -1;
    }

    public void add(int val) {
        if(map.containsKey(val)) {
            DNode node = map.get(val);
            if(node != null) {
                remove(node);
                map.put(val, null);
            }
        } else {
            DNode node = new DNode(val);
            tail.next = node;
            node.prev = tail;
            tail = node;
            map.put(val, node);
        }
        //System.out.print("After Insert: ");
        //print(head.next);
    }

    private void remove(DNode node) {
        if(node == tail) {
            node.prev.next = null;
            tail = node.prev;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    private void print(DNode head) {
        DNode cur=head;
        while(cur != null) {
            System.out.print(cur.value + ", ");
            cur = cur.next;
        }
        System.out.println();
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */

