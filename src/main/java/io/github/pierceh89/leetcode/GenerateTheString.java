package io.github.pierceh89.leetcode;

/**
 * 1374. Generate a String With Characters That Have Odd Counts
 * Time Complexity O(n) where n is the length of string to generate
 */
public class GenerateTheString {
    public String generateTheString(int n) {
        boolean[] used = new boolean[26];
        return genString(n, used);

    }

    public String genString(int n, boolean[] used) {
        StringBuilder sb = new StringBuilder();
        if (n%2==1) {
            int i;
            for(i=0; i<26; i++) {
                if(!used[i]) {
                    used[i] = true;
                    break;
                }
            }
            if(i < 26) {
                for(int j=0; j<n; j++) {
                    sb.append((char)(i+'a'));
                }
            }
            return sb.toString();
        }
        return genString(n-1, used) + genString(1, used);
    }
}
