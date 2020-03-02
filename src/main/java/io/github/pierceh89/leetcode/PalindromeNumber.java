package io.github.pierceh89.leetcode;

/**
 * 9. Palindrome Number
 * Time Complexity is O(log10(x))
 */
class PalindromeNumber {
	public boolean isPalindrome(int x) {
        // convert to string
        if (x < 0) {
            return false;
        }
        String n = Integer.toString(x);
        int size = n.length();
        for(int i=0; i<size/2; i++) {
            if(n.charAt(i) != n.charAt(size-1-i)) {
                return false;
            }
        }
        return true;
    }
}
