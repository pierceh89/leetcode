package io.github.pierceh89.leetcode;

/**
 * 12. Integer to Roman
 */
public class IntegerToRoman {
    public String intToRoman(int num) {
        if (num==0) {
            return "";
        }
        int[] values = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        while(num > 0) {
            for(int i=0; i<values.length; i++) {
                if(num >= values[i]) {
                    num -= values[i];
                    sb.append(symbols[i]);
                    break;
                }
            }
        }
        return sb.toString();
    }
}
