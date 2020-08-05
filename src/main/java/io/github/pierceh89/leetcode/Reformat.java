package io.github.pierceh89.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1417. Reformat The String
 */
public class Reformat {
    public String reformat(String s) {
        StringBuilder sb = new StringBuilder();
        List<Character> alpha = new ArrayList<>();
        List<Character> numer = new ArrayList<>();
        for(int i=0; i<s.length();i++) {
            char c = s.charAt(i);
            if(c-'a' >=0 && 'z'-c <=25) {
                alpha.add(c);
            } else {
                numer.add(c);
            }
        }
        if(Math.abs(alpha.size()-numer.size()) > 1) {
            return "";
        }
        List<Character> first = alpha.size()>numer.size() ? alpha : numer;
        List<Character> second = alpha.size()>numer.size() ? numer : alpha;
        int i=0;
        for(; i<second.size(); i++) {
            sb.append(first.get(i));
            sb.append(second.get(i));
        }
        if(i<first.size()) {
            sb.append(first.get(i++));
        }
        return sb.toString();
    }
}
