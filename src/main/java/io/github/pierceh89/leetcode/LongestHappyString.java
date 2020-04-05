package io.github.pierceh89.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 1405. Longest Happy String
 */
public class LongestHappyString {
    static class Pair {
        String c;
        int count;
        Pair(String cc, int cnt) {
            c = cc;
            count = cnt;
        }
    }
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        Queue<Pair> q = new PriorityQueue<>(3, (p1, p2) -> p2.count - p1.count);
        if(a > 0) q.offer(new Pair("a", a));
        if(b > 0) q.offer(new Pair("b", b));
        if(c > 0) q.offer(new Pair("c", c));
        String last = "";
        while(!q.isEmpty()) {
            Pair p = q.poll();
            if(!last.equals(p.c)) {
                add(sb, p, 2);
                last = p.c;
                if(p.count > 0) q.offer(p);
            } else if(q.isEmpty()) {
                return sb.toString();
            } else {
                Pair p2 = q.poll();
                if(p.count > p2.count)
                    add(sb, p2, 1);
                last = p2.c;
                if(p2.count > 0) q.offer(p2);
                q.offer(p);
            }
        }
        return sb.toString();
    }

    public void add(StringBuilder sb, Pair p, int con) {
        for(int i=0; i<con && p.count >0; i++) {
            sb.append(p.c);
            p.count--;
        }
    }
}
