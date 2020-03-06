package io.github.pierceh89.leetcode;

/**
 * 5. Longest Palindromic Substring
 */
class LongestPalindromicSubstring {
	// bruteforce
	// O(n^3) time complexity
	// O(1) space complexity
	public String longestPalindrome(String s) {
        if(s==null || s.isEmpty()) {
            return "";
        }
        String longest = s.substring(0,1);
        for(int start=0; start < s.length()-1; start++) {
            for(int end=s.length(); end>start && longest.length() < end-start; end--) {
                String sub=s.substring(start,end);
                if(isPalindrome(sub) && sub.length() > longest.length()) {
                    longest = sub;
                }
            }
        }
        
        return longest;
    }
    
    public boolean isPalindrome(String ss) {
        int size = ss.length();
        for(int i=0; i < size/2; i++) {
            if(ss.charAt(i) != ss.charAt(size-i-1)) {
                return false;
            }
        }
        return true;
    }
}
