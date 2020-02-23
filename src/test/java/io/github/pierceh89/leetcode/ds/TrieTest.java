package io.github.pierceh89.leetcode.ds;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

public class TrieTest {

    @Test
    public void buildTrie() {
        Trie t = Trie.build(Arrays.asList("mouse", "mousepad", "monitor"));
        System.out.println(t);
    }

    @Test
    public void testFindAll() {
        Trie t = Trie.build(Arrays.asList("abc", "ab", "c"));
        assertEquals(Collections.emptyList(), t.findAll(null));
//        assertEquals(Arrays.asList("abc", "ab", "c"), t.findAll(""));
        assertEquals(Collections.singletonList("c"), t.findAll("c"));
        assertEquals(Arrays.asList("ab", "abc"), t.findAll("ab"));
        assertEquals(Arrays.asList("ab", "abc"), t.findAll("a"));
    }
}