package io.github.pierceh89.leetcode;

/**
 * Product of Array Except Self
 */
public class ProductArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[] ret = new int[nums.length];
        int[] l = new int[nums.length];
        int[] r = new int[nums.length];
        l[0]=1;
        r[nums.length-1]=1;
        for(int i=1; i<nums.length; i++) {
            l[i]=nums[i-1]*l[i-1];
        }
        for(int i=nums.length-2; i>=0; i--) {
            r[i]=nums[i+1]*r[i+1];
        }
        for(int i=0; i<nums.length;i++) {
            ret[i]=l[i]*r[i];
        }

        return ret;
    }
}
