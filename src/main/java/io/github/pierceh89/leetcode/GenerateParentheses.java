package io.github.pierceh89.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. Generate Parentheses
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        generate("(", 1, 0, n, ret);
        return ret;
    }

    public void generate(String s, int open, int close, int n, List<String> ret) {
        if(s.length() == n*2) {
            ret.add(s);
            return;
        }

        if (open >= close && open < n) {
            generate(s + "(", open+1, close, n, ret);
            generate(s + ")", open, close+1, n, ret);
        }
        if (open == n) {
            generate(s + ")", open, close+1, n, ret);
        }
    }
}
