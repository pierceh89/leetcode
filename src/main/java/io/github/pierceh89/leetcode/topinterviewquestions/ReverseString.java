package io.github.pierceh89.leetcode.topinterviewquestions;

/**
 * https://leetcode.com/explore/featured/card/top-interview-questions-easy/127/strings/879/
 * Reverse String (in place)
 * swap first and last character, second and second from last and so on
 * until array become reverse
 */
public class ReverseString {
    public void reverseString(char[] s) {
        for(int i=0; i < s.length/2; i++) {
            char temp = s[i];
            s[i] = s[s.length-i-1];
            s[s.length-i-1]=temp;
        }
    }
}
