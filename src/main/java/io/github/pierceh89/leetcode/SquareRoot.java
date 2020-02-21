package io.github.pierceh89.leetcode;

import java.math.BigInteger;

/**
 * Since it is binary search,
 * Time complexity is O(nLog(n))
 */
public class SquareRoot {
    public int mySqrt(int x) {

        // sqrt is not greater than x/2 + 1
        int e = x/2 + 1;
        int s = 0;
        // binary search
        while (s <= e) {
            int mid = s + (e-s)/2;
            BigInteger sq = BigInteger.valueOf(mid).multiply(BigInteger.valueOf(mid));
            if (sq.equals(BigInteger.valueOf(x))) return mid;
            if (sq.compareTo(BigInteger.valueOf(x)) == -1) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return e;
    }

    public static void main(String[] args) {
        SquareRoot sr = new SquareRoot();
        sr.mySqrt(2147395599);
    }
}
