package io.github.pierceh89.leetcode;

/**
 * Leetcoding Challenge Week4 Day2
 */
public class BitwiseNumbersRange {
    public int rangeBitwiseAnd(int m, int n) {
        int min = largestBit(m);
        int max = largestBit(n);
        if(min!=max || min==0) {
            return 0;
        }
        int ret = min;
        m = m-min;
        n = n-min;
        while(true) {
            min = largestBit(m);
            max = largestBit(n);
            if(min != max || min==0) {
                break;
            }
            ret += min;
            m = m-min;
            n = n-min;
        }
        return ret;
    }

    public int largestBit(int val) {
        if(val == 0) {
            return 0;
        }
        int ret=1;
        while(val > 1) {
            val = val >> 1;
            ret *= 2;
        }
        return ret;
    }
}
