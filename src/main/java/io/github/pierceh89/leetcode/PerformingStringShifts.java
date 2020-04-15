package io.github.pierceh89.leetcode;

/**
 * Performing String Shifts
 */
public class PerformingStringShifts {
    public String stringShift(String s, int[][] shift) {
        int len = s.length();
        int tsh = 0;
        for(int[] shi : shift) {
            if(shi[0]==1) tsh += shi[1];
            else tsh -= shi[1];
        }
        tsh = tsh%len;
        if(tsh>0) return s.substring(s.length()-tsh) + s.substring(0, s.length()-tsh);
        return s.substring(-tsh) + s.substring(0, -tsh);
    }
}
