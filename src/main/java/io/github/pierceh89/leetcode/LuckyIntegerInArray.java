package io.github.pierceh89.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 1394. Find Lucky Integer in an Array
 */
public class LuckyIntegerInArray {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int val : arr) {
            Integer cnt = countMap.computeIfAbsent(val, k -> 0);
            countMap.put(val, cnt+1);
        }
        int ret = -1;
        for(int k : countMap.keySet()) {
            int v = countMap.get(k);
            if(k==v && ret < k) {
                ret = k;
            }
        }
        return ret;
    }
}
