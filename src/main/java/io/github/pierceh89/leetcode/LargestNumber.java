package io.github.pierceh89.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 179. Largest Number
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        Queue<String> q = new PriorityQueue<>(nums.length, (a, b) -> {
            String ab = a+b, ba=b+a;
            return ba.compareTo(ab);
        });
        for(int n : nums) {
            q.offer(Integer.toString(n));
        }
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()) {
            sb.append(q.poll());
        }
        String ret = sb.toString();
        if (ret.startsWith("0")) {
            return "0";
        }
        return ret;
    }
}
