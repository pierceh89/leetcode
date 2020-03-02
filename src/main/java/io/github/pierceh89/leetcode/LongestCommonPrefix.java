package io.github.pierceh89.leetcode;

/**
 * 14. Longest Common Prefix
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length==0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i=0;
        boolean cont = true;
        while(true) {
            if (i >= strs[0].length()) {
                break;
            }
            char c = strs[0].charAt(i);
            for(int j=1; j<strs.length; j++) {
                if(i >= strs[j].length()) {
                    cont=false;
                    break;
                }
                if (c != strs[j].charAt(i)) {
                    cont=false;
                    break;
                }
            }
            if(!cont) {
                break;
            }
            i++;
            sb.append(c);
        }
        return sb.toString();
    }
}
