package io.github.pierceh89.leetcode;

/**
 * 326. Power of Three
 */
class PowerOfThree {
	public boolean isPowerOfThree(int n) {
        if(n<=0) {
            return false;
        }
        while(n > 1) {
            int mod = n%3;
            if(mod != 0) {
                return false;
            }
            n=n/3;
        }
        return true;
    }
}
