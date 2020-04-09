package io.github.pierceh89.leetcode;

/**
 * 844. Backspace String Compare
 */
public class BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        String s = parse(S);
        String t = parse(T);

        return s.equals(t);
    }

    public String parse(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) {
            if (c != '#') {
                sb.append(c);
            } else {
                if(sb.length()>0) {
                    sb.deleteCharAt(sb.length()-1);
                }
            }
        }
        return sb.toString();
    }
}
