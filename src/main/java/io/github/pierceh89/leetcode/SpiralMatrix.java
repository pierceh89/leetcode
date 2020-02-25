package io.github.pierceh89.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    // Time complexity is O(n)
    public List<Integer> spiralOrder(int[][] matrix) {
        int[][] dir = new int[][]{
                new int[]{0, 1},
                new int[]{1, 0},
                new int[]{0, -1},
                new int[]{-1, 0}
        };

        List<Integer> result = new ArrayList<>();
        int row = matrix.length;
        if (row == 0) {
            return result;
        }
        int col = matrix[0].length;

        int size= row*col;
        int i=0;
        int d=0;
        int r=0, c=0;
        int minR=0, minC=0;

        while (i < size) {
            if (r < row && r >=minR && c >=minC && c < col) {
                result.add(matrix[r][c]);
                i++;
            }
            if (d==0 && c >=col) {
                c--;
                minR++;
                d = (d+1)%4;
            }
            if (d==1 && r >= row) {
                r--;
                col--;
                d = (d+1)%4;
            }
            if (d==2 && c < minC) {
                c++;
                row--;
                d = (d+1)%4;
            }
            if (d==3 && r < minR) {
                r++;
                minC++;
                d = (d+1)%4;

            }
            r = r + dir[d][0];
            c = c + dir[d][1];
        }

        return result;
    }
}
