package io.github.pierceh89.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int K) {
        Queue<int[]> pointQueue = new PriorityQueue<>(K, (a, b) -> {
            int asqr = a[0] * a[0] + a[1] * a[1];
            int bsqr = b[0] * b[0] + b[1] * b[1];
            return asqr - bsqr;
        });
        for (int[] p : points) {
            pointQueue.offer(p);
        }
        int[][] ret = new int[K][2];
        for (int i = 0; i < K; i++) {
            int[] p = pointQueue.poll();
            ret[i][0] = p[0];
            ret[i][1] = p[1];
        }
        return ret;
    }
}
