package io.github.pierceh89.leetcode;

/**
 * 14. Longest Common Prefix
 * Vertical scanning approach
 * Time Complexity is O(S) where S is the sum of all strings in array
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length==0) {
            return "";
        }
		StringBuilder sb = new StringBuilder();
        for(int i=0; i < strs[0].length(); i++) {
            if (i >= strs[0].length()) {
                return sb.toString();
            }
            char c = strs[0].charAt(i);
            for(int j=1; j<strs.length; j++) {
                if ((i >= strs[j].length()) ||
                    (c != strs[j].charAt(i))){
                    return sb.toString();
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
