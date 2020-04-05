package io.github.pierceh89.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 1403. Minimum Subsequence in Non-Increasing Order
 */
public class MinSubsequence {
    public List<Integer> minSubsequence(int[] nums) {
        int sum=0;
        Queue<Integer> q = new PriorityQueue<Integer>(nums.length, (n1, n2) -> n2-n1);
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            q.offer(nums[i]);
        }
        List<Integer> ret = new ArrayList<>();
        int retSum=0;
        while(!q.isEmpty()) {
            int num = q.poll();
            ret.add(num);
            retSum += num;
            sum -= num;
            if(retSum > sum) {
                break;
            }
        }
        return ret;
    }
}
