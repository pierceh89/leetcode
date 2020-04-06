package io.github.pierceh89.leetcode;

import java.util.*;

/**
 * 17. Letter Combinations of a Phone Number
 */
public class LetterCombination {
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) {
            return Collections.emptyList();
        }
        Map<Character, String> phone = new HashMap<>();
        phone.put('2', "abc");
        phone.put('3', "def");
        phone.put('4', "ghi");
        phone.put('5', "jkl");
        phone.put('6', "mno");
        phone.put('7', "pqrs");
        phone.put('8', "tuv");
        phone.put('9', "wxyz");

        List<String> ret = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        comb(0, digits, phone, sb, ret);
        return ret;
    }

    public void comb(int cur, String digits, Map<Character, String> letters, StringBuilder sb, List<String> ret) {
        if(cur == digits.length()) {
            ret.add(sb.toString());
            return;
        }
        String lettercomb = letters.get(digits.charAt(cur));
        for(int i=0; i<lettercomb.length(); i++) {
            sb.append(lettercomb.charAt(i));
            comb(cur+1, digits, letters, sb, ret);
            sb.deleteCharAt(cur);
        }
    }
}
