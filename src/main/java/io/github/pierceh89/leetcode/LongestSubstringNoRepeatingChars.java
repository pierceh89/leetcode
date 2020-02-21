package io.github.pierceh89.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * time complexity O(n^2)
 */
public class LongestSubstringNoRepeatingChars {
    public static void main(String[] args) {
        LongestSubstringNoRepeatingChars sut = new LongestSubstringNoRepeatingChars();
        int maxLen = sut.lengthOfLongestSubstring("xxzqi");
        System.out.println(4 == maxLen);
        maxLen = sut.lengthOfLongestSubstring(" ");
        System.out.println(1 == maxLen);
    }
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        int maxLen = 0;
        for(int idx=0; idx < s.length(); idx++) {
            for (int i=idx; i < s.length(); i++) {
                if (map.containsKey(s.charAt(i))) {
                    if (map.size() > maxLen) {
                        maxLen = map.size();
                    }
                    map.clear();
                    break;
                }
                else {
                    map.put(s.charAt(i), i);
                }
            }
        }
        if (map.size() > maxLen) {
            return map.size();
        }
        return maxLen;
    }
}
