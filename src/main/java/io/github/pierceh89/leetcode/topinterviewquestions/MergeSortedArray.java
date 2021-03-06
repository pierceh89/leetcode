package io.github.pierceh89.leetcode.topinterviewquestions;

/**
 * Time Complexity is O(m + n)
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // fill in the array reverse
        int size = m + n;
        int p1 = m - 1, p2 = n - 1;
        for (int i = size - 1; i >= 0; i--) {
            if (p1 >= 0 && p2 >= 0) {
                if (nums1[p1] > nums2[p2]) {
                    nums1[i] = nums1[p1];
                    p1--;
                } else {
                    nums1[i] = nums2[p2];
                    p2--;
                }
            } else {
                if (p2 >= 0) {
                    nums1[i] = nums2[p2];
                    p2--;
                }
                if (p1 >= 0) {
                    nums1[i] = nums1[p1];
                    p1--;
                }
            }
        }
    }

    // second solution written on Aug. 6th
    // https://leetcode.com/explore/featured/card/top-interview-questions-easy/96/sorting-and-searching/587/
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i=m+n-1;
        int j=m-1, k=n-1;
        for(; j>=0 && k>=0; i--) {
            if (nums1[j]>nums2[k]) {
                nums1[i]=nums1[j];
                j--;
            } else {
                nums1[i]=nums2[k];
                k--;
            }
        }
        for(; j>=0; j--) {
            nums1[i] = nums1[j];
            i--;
        }
        for(; k>=0; k--) {
            nums1[i] = nums2[k];
            i--;
        }
    }

    public static void main(String[] args) {
        MergeSortedArray msa = new MergeSortedArray();
        int[] nums = new int[]{1,2,3, 0, 0, 0};
        int[] nums2 = new int[]{2,5,6};
        msa.merge(nums, 3, nums2, 3);

        for (int i : nums){
            System.out.print(i + ", ");
        }
    }
}
