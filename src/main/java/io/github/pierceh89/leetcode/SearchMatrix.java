package io.github.pierceh89.leetcode;

/**
 * 240. Search a 2D Matrix II
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if(row==0) {
            return false;
        }
        int col= matrix[0].length;
        int i=0, j=0;
        while(i < row && j < col) {
            if(matrix[i][j] == target) {
                return true;
            } else if(matrix[i][j] > target) {
                if(i+1 < row) {
                    i++; j=0;
                } else {
                    break;
                }
            } else { // matrix[i][j] < target
                if(j+1<col) {
                    j++;
                } else if(i+1 < row) {
                    i++; j=0;
                } else {
                    break;
                }
            }
        }
        return false;
    }
}
