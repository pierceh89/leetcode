package io.github.pierceh89.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1381. Design a Stack with Increment Operation
 */
public class DesignStackWithIncrementOperation {
    static class CustomStack {
        int maxSize;
        List<Integer> d;


        public CustomStack(int maxSize) {
            this.maxSize = maxSize;
            d = new ArrayList<>(maxSize);

        }

        public void push(int x) {
            if(d.size() < maxSize) {
                d.add(x);
            }
        }

        public int pop() {
            if(d.size() == 0) {
                return -1;
            }
            int len = d.size();
            int ret = d.get(len-1);
            d.remove(len-1);
            return ret;
        }

        public void increment(int k, int val) {
            int len = d.size();
            int kk = k < len ? k : len;
            for(int i=0; i < kk; i++) {
                int newVal = d.get(i) + val;
                d.set(i, newVal);
            }
        }
    }
}
