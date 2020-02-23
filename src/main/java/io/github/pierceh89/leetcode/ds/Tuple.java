package io.github.pierceh89.leetcode.ds;

public class Tuple {
    public int r;
    public int c;
    public static Tuple of(int r, int c) {
        Tuple t = new Tuple();
        t.r = r;
        t.c = c;
        return t;
    }

}
