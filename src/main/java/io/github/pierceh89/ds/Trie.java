package io.github.pierceh89.ds;

import java.util.*;

public class Trie {

    boolean terminal = false;
    Map<Character, Trie> children;

    private Trie() {
        children = new HashMap<>();
    }

    @Override
    public String toString() {
        return "terminal: " + terminal + " " + children.toString();
    }

    public static Trie build(List<String> strings) {
        Trie t = new Trie();
        for (String s : strings) {
            t.insert(s);
        }
        return t;
    }

    public void insert(String s) {
        int i=0;
        Trie t = children.computeIfAbsent(s.charAt(i++), k -> new Trie());
        while (i < s.length()) {
            t = t.children.computeIfAbsent(s.charAt(i++), k -> new Trie());
        }
        t.terminal = true;
    }

    public static class Pair {
        String prefix;
        Trie trie;
        public static Pair of(String prefix, Trie trie) {
            Pair p = new Pair();
            p.prefix = prefix;
            p.trie = trie;
            return p;
        }
    }

    public List<String> findAll(String str) {
        if (str == null) {
            return Collections.emptyList();
        }
        List<String> results = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        if (!children.containsKey(str.charAt(0))) {
            return Collections.emptyList();
        }
        q.offer(Pair.of(str.substring(0, 1), children.get(str.charAt(0))));
        int i=1;
        int size = str.length();
        while(!q.isEmpty()) {
            Pair p = q.poll();
            if (i < size) {
                char c = str.charAt(i);
                if (p.trie.children.containsKey(c)) {
                    String newPrefix = p.prefix + c;
                    q.offer(Pair.of(newPrefix, p.trie.children.get(c)));
                }
                i++;
            } else {
                // get all children node
                if (p.trie.terminal) {
                    results.add(p.prefix);
                }
                p.trie.children.forEach((key, value) -> q.offer(Pair.of(p.prefix + key, value)));
            }
        }
        return results;
    }
}
