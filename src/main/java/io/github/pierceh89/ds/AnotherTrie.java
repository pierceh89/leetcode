package io.github.pierceh89.ds;

import java.util.HashMap;
import java.util.Map;

public class AnotherTrie {

    boolean terminal = false;
    Map<Character, AnotherTrie> children;

    /** Initialize your data structure here. */
    public AnotherTrie() {
        children = new HashMap<>();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        AnotherTrie t = this;
        for(int i=0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(t.children.containsKey(c)) {
                t = t.children.get(c);
            } else {
                AnotherTrie newT = new AnotherTrie();
                t.children.put(c, newT);
                t = newT;
            }
            if (i == word.length()-1) {
                t.terminal = true;
            }
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        System.out.println("search input: "+word);
        AnotherTrie t = this;
        for(int i=0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!t.children.containsKey(c)) {
                return false;
            }
            t = t.children.get(c);
        }
        if(!t.terminal) {
            return false;
        }

        return true;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        System.out.println("startsWith input: "+prefix);
        AnotherTrie t = this;
        int i=0;
        for(; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!t.children.containsKey(c)) {
                return false;
            }
            t = t.children.get(c);
        }
        if (i < prefix.length()) {
            return false;
        }

        return true;
    }
}
