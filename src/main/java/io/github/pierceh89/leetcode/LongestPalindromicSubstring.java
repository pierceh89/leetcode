package io.github.pierceh89.leetcode;

/**
 * 5. Longest Palindromic Substring
 * Dynamic Programming Solution
 * Time Complexity O(n^2)
 * Space Complexity O(n^2)
 *
 * There's even O(n) solution
 * https://leetcode.com/problems/longest-palindromic-substring/discuss/304553/O(n)-solution-Manacher%27s-Algorithm
 */
class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        int sz = s.length();
        int maxlen = 1;
        String maxstr = s.substring(0, 1);
        Boolean[][] pal = new Boolean[sz][sz];
        for (int i = 0; i < sz; i++) {
            if (sz - i < maxlen) {
                break;
            }
            for (int j = sz - 1; j >= i; j--) {
                pal[i][j] = isPalindrome(i, j, pal, s);
                if (pal[i][j] && j - i + 1 > maxlen) {
                    maxlen = j - i + 1;
                    maxstr = s.substring(i, j + 1);
                }
            }
        }
        return maxstr;
    }

    public boolean isPalindrome(int i, int j, Boolean[][] pal, String s) {
        if (pal[i][j] != null) {
            return pal[i][j];
        }
        if (i == j) {
            pal[i][j] = true;
        } else if (j - i == 1) {
            pal[i][j] = s.charAt(i) == s.charAt(j);
        } else {
            pal[i][j] = s.charAt(i) == s.charAt(j) && isPalindrome(i + 1, j - 1, pal, s);
        }
        return pal[i][j];
    }
}
