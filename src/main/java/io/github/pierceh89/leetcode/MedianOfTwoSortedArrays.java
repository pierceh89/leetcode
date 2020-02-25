package io.github.pierceh89.leetcode;

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // O(m+n)
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] merged = new int[len1+len2];
        int size = merged.length;
        int i=0, i1=0, i2=0;
        for(; i < size && i1 <len1 && i2 <len2; i++) {
            if(nums1[i1] < nums2[i2]) {
                merged[i] = nums1[i1];
                i1++;
            } else {
                merged[i] = nums2[i2];
                i2++;
            }
        }
        while(i1 < len1) {
            merged[i] = nums1[i1];
            i++; i1++;
        }
        while(i2 < len2) {
            merged[i] = nums2[i2];
            i++; i2++;
        }

        if (size % 2 == 1) {
            return merged[size/2];
        } else {
            return (merged[size/2-1] + merged[size/2])/2.0;
        }
    }
}
