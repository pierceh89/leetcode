package io.github.pierceh89.leetcode;

/**
 * 1404. Number of Steps to Reduce a Number in Binary Representation to One
 */
public class NumSteps {
    public int numSteps(String s) {
        int steps = 0;
        int addr = 0;
        int pos = s.length()-1;
        char[] ss = s.toCharArray();
        while(pos > 0 ) {
            if(ss[pos] =='1' && addr==0) {
                addr=1;
            } else if(ss[pos] =='1' && addr==1) {
                pos--;
            } else if (ss[pos] =='0' && addr==0) {
                pos--;
            } else {
                ss[pos] = '1';
            }
            steps++;
        }
        if(addr == 1) {
            steps++;
        }
        return steps;
    }
}
