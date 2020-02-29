package io.github.pierceh89.leetcode;

/**
 * 1037. Valid Boomerang
 */
public class ValidBoomerange {
	public boolean isBoomerang(int[][] points) {
        // check straight line
        if(isStraight(points,0) || isStraight(points,1)) {
            return false;
        }
        return !isSame(points[0], points[1]) &&
            !isSame(points[0], points[2]) &&
            !isSame(points[1], points[2]);
    }
    
    public boolean isStraight(int[][] points, int idx) {
        //idx 0: y, idx 1: x
        int[] p = new int[3];
        for(int i=0; i<3; i++) {
            p[i]=points[i][idx];
        }
        
        if(p[0]==p[1] && p[0]==p[2] && p[1]==p[2]) {
            return true;
        }
        
        // diagonal, dy/dx should be the same
        int dx1 = points[1][0]-points[0][0];
        int dy1 = points[1][1]-points[0][1];
        int dx2 = points[2][0]-points[0][0];
        int dy2 = points[2][1]-points[0][1];
        return dx1 !=0 && dx2 !=0 && ((dy1/(double)dx1)==(dy2/(double)dx2)); 
    }
    
    public boolean isSame(int[] p1, int[] p2) {
        return p1[0] == p2[0] && p1[1] == p2[1];
    }
}
