package io.github.pierceh89.leetcode;

/**
 * 13. Roman to Integer
 */
public class RomanToInteger {
    public int romanToInt(String s) {
        int val = 0;
        int size=s.length();
        for(int i=0; i < size; i++) {
            char c = s.charAt(i);
            int parsed=0;
            switch(c) {
                case 'I':
                    parsed=1;
                    if (parseNext(i, size, s, 'V') ||
                            parseNext(i, size, s, 'X')) {
                        parsed = -1 * parsed;
                    }
                    break;
                case 'V':
                    parsed=5;
                    break;
                case 'X':
                    parsed=10;
                    if (parseNext(i, size, s, 'L') ||
                            parseNext(i, size, s, 'C')) {
                        parsed = -1 * parsed;
                    }
                    break;
                case 'L':
                    parsed=50;
                    break;
                case 'C':
                    parsed=100;
                    if (parseNext(i, size, s, 'D') ||
                            parseNext(i, size, s, 'M')) {
                        parsed= -1 * parsed;
                    }
                    break;
                case 'D':
                    parsed=500;
                    break;
                case 'M':
                    parsed=1000;
                    break;
            }
            val += parsed;
        }

        return val;
    }
    public boolean parseNext(int idx, int size, String s, char lookup) {
        return idx + 1 < size && s.charAt(idx + 1) == lookup;
    }
}
