package io.github.pierceh89.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 30 day leetcoding challenge week1 day7
 * Counting Elements
 */
public class CountingElements {
    public int countElements(int[] arr) {
        Set<Integer> s = new HashSet<>();
        for(int i : arr) {
            s.add(i);
        }
        int count=0;
        for(int val : arr) {
            if(s.contains(val + 1)) {
                count++;
            }
        }
        return count;
    }
}
