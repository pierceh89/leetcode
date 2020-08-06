package io.github.pierceh89.leetcode.topinterviewquestions;

/**
 * https://leetcode.com/explore/featured/card/top-interview-questions-easy/99/others/565/
 * compute Hamming weight https://en.wikipedia.org/wiki/Hamming_weight
 *
 */
public class NumberOf1Bits {
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0) {
            count = count + (n & 1);
            n = n >>> 1;
        }
        return count;
    }

    public int hammingWeight2(int n) {
        int bits=0;
        int mask=1;
        for(int i=0; i<32; i++) {
            if((n & mask) != 0) {
                bits++;
            }
            mask = mask << 1;
        }
        return bits;
    }
}
