package io.github.pierceh89.leetcode;

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
//    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
//        //binary tree
//        Trie t = Trie.build(Arrays.stream(products).collect(Collectors.toList()));
//        List<List<String>> result = new ArrayList<>();
//        for (int i = 1; i <= searchWord.length(); i++) {
//            result.add(t.findAll(searchWord.substring(0, i)));
//        }
//        return result.stream()
//                .map(list -> list.stream()
//                        .sorted()
//                        .limit(3)
//                        .collect(Collectors.toList()))
//                .collect(Collectors.toList());
//    }

    public static class Trie {
        char c;
        boolean terminal;
        Trie[] children;
        Trie(char c) {
            this.c = c;
            this.children = new Trie[26];
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        if (searchWord == null || searchWord.isEmpty()) {
            return result;
        }

        Trie root = new Trie('#'); // dummy
        for (String p : products) {
            insert(root, p);
        }

        for (int i=0; i < searchWord.length(); i++) {
            StringBuilder sb = new StringBuilder();
            List<String> list = new ArrayList<>();
            String subWord = searchWord.substring(0, i+1);
            sb.append(subWord);
            Trie node = root;
            for (int j=0; j < subWord.length(); j++) {
                if (node == null) {
                    break;
                }
                node = node.children[subWord.charAt(j)-'a'];
            }
            dfs(sb, node, list, 3);
            result.add(list);
        }
        return result;
    }

    public void dfs(StringBuilder sb, Trie node, List<String> result, int limit){
        if (node == null) {
            return;
        }
        if (result.size() >= limit) {
            return;
        }
        if (node.terminal) {
            result.add(sb.toString());
        }
        if (node.children != null) {
            for (int i=0; i < 26; i++) {
                if(node.children[i] != null) {
                    sb.append(node.children[i].c);
                    dfs(sb, node.children[i], result, limit);
                    sb.deleteCharAt(sb.length()-1);
                }
            }
        }
    }

    public void insert(Trie root, String s) {
        if (s == null || s.isEmpty()) {
            return;
        }

        Trie t = root;
        for(int i=0; i < s.length(); i++) {
            int pos = s.charAt(i)-'a';
            if(t.children[pos] == null) {
                t.children[pos] = new Trie(s.charAt(i));
            }
            t = t.children[pos];
        }
        t.terminal = true;
    }
}
