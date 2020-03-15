package io.github.pierceh89.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 1380. Lucky Numbers in a Matrix
 */
public class LuckyNumbersInMatrix {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int rowMin[] = new int[row];
        int colMax[] = new int[col];
        for (int i=0; i< row; i++) {
            Queue<Integer> q = new PriorityQueue<Integer>(1, (a, b) -> a-b);
            for(int j=0; j<col; j++) {
                q.offer(matrix[i][j]);
            }
            rowMin[i] = q.poll();
        }
        for (int j=0; j<col; j++) {
            Queue<Integer> q = new PriorityQueue<Integer>(1, (a, b) -> b-a);
            for(int i=0; i<row; i++) {
                q.offer(matrix[i][j]);
            }
            colMax[j]= q.poll();
        }
        List<Integer> luckyNums = new ArrayList<>();
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if (rowMin[i] == colMax[j]) {
                    luckyNums.add(rowMin[i]);
                }
            }
        }
        return luckyNums;
    }
}
