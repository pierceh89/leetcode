package io.github.pierceh89.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// please check better solution: https://leetcode.com/problems/verifying-an-alien-dictionary/discuss/203185/JavaC%2B%2BPython-Mapping-to-Normal-Order

public class VerifyingAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Character> orderMap = new HashMap<>();
        for(int i=0; i<order.length(); i++) {
            char c = order.charAt(i);
            orderMap.put(c, (char)('a'+i));
        }
        List<String> converted = new ArrayList<>();
        for(String word : words) {
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<word.length(); i++) {
                sb.append(orderMap.get(word.charAt(i)));
            }
            converted.add(sb.toString());
        }
        List<String> sorted = converted.stream().sorted().collect(Collectors.toList());
        return converted.equals(sorted);
    }
}
