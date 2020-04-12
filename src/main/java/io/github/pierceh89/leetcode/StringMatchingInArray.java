package io.github.pierceh89.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 5380. String Matching in an Array
 */
public class StringMatchingInArray {
    public List<String> stringMatching(String[] words) {
        List<String> ret= new ArrayList<>();
        for(int i=0; i<words.length; i++) {
            for(int j=0; j<words.length; j++) {
                if(i==j) {
                    continue;
                }
                if(words[j].contains(words[i])) {
                    if(!ret.contains(words[i])) ret.add(words[i]);
                }
            }
        }
        return ret;
    }
}
