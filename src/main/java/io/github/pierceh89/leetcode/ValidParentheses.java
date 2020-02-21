package io.github.pierceh89.leetcode;

import java.util.Stack;

/**
 * Time complexity is O(n)
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> paren = new Stack<>();
        int n = s.length();
        for (int i=0; i < n; i++) {
            char cur = s.charAt(i);
            if (paren.empty()) {
                paren.push(cur);
            } else {
                Character top = paren.peek();
                if (shouldRemove(top, cur)) {
                    paren.pop();
                } else {
                    paren.push(cur);
                }
            }
        }

        return paren.empty();
    }

    public boolean shouldRemove(char earlier, char later) {
        if (earlier == '(' && later == ')') {
            return true;
        } else if (earlier == '[' && later == ']') {
            return true;
        } else if (earlier == '{' && later == '}') {
            return true;
        } else {
            return false;
        }
    }
}
