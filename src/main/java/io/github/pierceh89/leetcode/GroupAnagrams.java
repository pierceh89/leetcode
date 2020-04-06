package io.github.pierceh89.leetcode;

import java.util.*;

/**
 * 49. Group Anagrams
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> ret = new HashMap<>();
        for(String s : strs) {
            String sorted = sort(s);
            List<String> ls = ret.computeIfAbsent(sorted, k -> new ArrayList<>());
            ls.add(s);
        }
        return new ArrayList<>(ret.values());
    }
    public String sort(String s) {
        char[] ss = s.toCharArray();
        Arrays.sort(ss);
        return new String(ss);
    }
}
