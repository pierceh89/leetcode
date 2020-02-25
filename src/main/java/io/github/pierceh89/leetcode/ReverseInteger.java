package io.github.pierceh89.leetcode;

public class ReverseInteger {
    // O(log10 of x)
    public int reverse(int x) {
        int maxLength = 10;
        int[] digit = new int[maxLength];
        int i=0;
        boolean positive = x > 0 ? true : false;
        int val = positive ? x : -x;
        while(val > 0) {
            int d = val % 10;
            if (d == 0 && i==0) {
                val = val / 10;
                continue;
            }
            digit[i] = d;
            val = val / 10;
            i++;
        }

        // reverse
        int rval = 0;
        if (digit[0]>2 && i>=9) {
            // overflow
            return 0;
        }
        for(int j=0; j<i; j++) {
            rval += digit[j] * Math.pow(10, i-j-1);
        }
        if (rval < 0 || rval == Integer.MAX_VALUE) {
            // overflow
            return 0;
        }
        if (positive) {
            return rval;
        } else {
            return -rval;
        }
    }
}
