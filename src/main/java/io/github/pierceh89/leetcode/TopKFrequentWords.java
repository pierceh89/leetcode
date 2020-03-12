package io.github.pierceh89.leetcode;

import java.util.*;

/**
 * 692. Top K Frequent Words
 * O(n) for putting n words to map
 * O(nlogk) for putting Pair(word,frequency)
 * making PriorityQueue size k can keep insertion O(logk)
 * O(k) for fetching k words from priority queue
 * Time Complexity is O(nlogk)
 * Space Complexity is O(n)
 */
public class TopKFrequentWords {
    static class Pair {
        String word;
        int freq;
        Pair(String w, int f) {
            word = w;
            freq = f;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freqMap = new HashMap<>();
        for(String w : words) {
            if(freqMap.containsKey(w)) {
                Integer freq = freqMap.get(w);
                freqMap.put(w, freq+1);
            } else {
                freqMap.put(w, 1);
            }
        }
        Queue<Pair> q = new PriorityQueue<>(k, (a, b) -> {
            if(a.freq != b.freq) {
                return b.freq-a.freq;
            }
            return a.word.compareTo(b.word);
        });

        freqMap.forEach((key, value) -> q.offer(new Pair(key, value)));

        List<String> ret = new ArrayList<>();
        for(int i=0; i<k; i++) {
            Pair p = q.poll();
            ret.add(p.word);
        }

        return ret;
    }
}
