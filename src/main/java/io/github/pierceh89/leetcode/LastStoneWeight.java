package io.github.pierceh89.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 1046. Last Stone Weight
 */
public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> q = new PriorityQueue<>(stones.length, (v1, v2) -> v2-v1);
        for(int i : stones) {
            q.offer(i);
        }
        while(q.size() > 1) {
            int first = q.poll();
            int second = q.poll();
            if(first-second > 0) {
                q.offer(first-second);
            }
        }
        if(q.size() > 0) {
            return q.poll();
        }
        return 0;
    }
}
