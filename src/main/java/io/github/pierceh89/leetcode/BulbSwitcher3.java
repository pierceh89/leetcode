package io.github.pierceh89.leetcode;

/**
 * 1375. Bulb Switcher III
 * Time Complexity is O(n)
 * Idea is that curSum at time k
 * should be equal to lb(lb+1)/2
 * since numbering bulb is natural number
 */
public class BulbSwitcher3 {
    public int numTimesAllBlue(int[] light) {
        int size=light.length;
        int m=0;
        int lb=light[0];
        long curSum=0;
        for(int k=0; k<size; k++) {
            curSum = curSum + light[k];
            if(lb < light[k]) {
                lb=light[k];
            }
            if(((long)lb*(long)(lb+1))/ 2L ==curSum) {
                m++;
            }
        }
        return m;
    }
}
