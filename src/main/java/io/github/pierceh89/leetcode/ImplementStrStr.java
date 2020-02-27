package io.github.pierceh89.leetcode;

/**
 * 28. Implement strStr()
 * Time complexity is O(m*n)
 * where m, n are length of haystack and length of needle respectively
 */
public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.isEmpty()) {
            return 0;
        }

        int nsize = needle.length();
        int hsize = haystack.length();
        for(int i=0; i < hsize; i++) {
            if (i+nsize > hsize) {
                return -1;
            }
            boolean found=true;
            for(int j=0; j<nsize; j++) {
                if(haystack.charAt(i+j) != needle.charAt(j)) {
                    found=false;
                    break;
                }
            }
            if (found) {
                return i;
            }
        }
        return -1;
    }
}
