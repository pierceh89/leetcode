package io.github.pierceh89.leetcode;

import io.github.pierceh89.leetcode.ds.Trie;

import java.util.*;
import java.util.stream.Collectors;

public class SearchSuggestionsSystem {
    public List<List<String>> suggestedProductsBruteForce(String[] products, String searchWord) {
        // build map
        Map<String, Set<String>> map = new HashMap<>();
        int size = products.length;
        for (int i = 0; i < size; i++) {
            String product = products[i];
            for (int len = 1; len <= product.length(); len++) {
                String sub = product.substring(0, len);
                if (map.containsKey(sub)) {
                    // no repeated elements in products
                    Set<String> prds = map.get(sub);
                    prds.add(product);
                } else {
                    Set<String> prds = new TreeSet<>();
                    prds.add(product);
                    map.put(sub, prds);
                }
            }
        }

        List<List<String>> result = new ArrayList<>();
        for (int i = 1; i <= searchWord.length(); i++) {
            String s = searchWord.substring(0, i);
            if (map.containsKey(s)) {
                result.add(map.get(s).stream().limit(3).collect(Collectors.toList()));
            } else {
                result.add(Collections.emptyList());
            }
        }
        return result;
    }

    // Solution using Trie
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        //binary tree
        Trie t = Trie.build(Arrays.stream(products).collect(Collectors.toList()));
        List<List<String>> result = new ArrayList<>();
        for (int i = 1; i <= searchWord.length(); i++) {
            result.add(t.findAll(searchWord.substring(0, i)));
        }
        return result.stream()
                .map(list -> list.stream()
                        .sorted()
                        .limit(3)
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }
}
