package io.github.pierceh89.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1391. Check if There is a Valid Path in a Grid
 * https://leetcode.com/problems/check-if-there-is-a-valid-path-in-a-grid/discuss/547371/Java-clean-BFS
 */
public class ValidPathInGrid {
    public boolean hasValidPath(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int[][][] street = {
                {{0, -1}, {0, 1}},
                {{-1, 0}, {1, 0}},
                {{0, -1}, {1, 0}},
                {{0,  1}, {1, 0}},
                {{0, -1}, {-1,0}},
                {{0,  1}, {-1,0}}
        };
        boolean[][] visited = new boolean[r][c];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        visited[0][0] = true;
        while(!q.isEmpty()) {
            int[] pos = q.poll();
            int str = grid[pos[0]][pos[1]] -1;
            for(int[] path: street[str]) {
                int rr = pos[0] + path[0];
                int cc = pos[1] + path[1];
                if(rr < 0 || rr >= r || cc < 0 || cc >=c || visited[rr][cc]) {
                    continue;
                }
                for(int[] backdir: street[grid[rr][cc]-1]) {
                    if(rr + backdir[0] == pos[0] && cc + backdir[1] == pos[1]) {
                        visited[rr][cc]= true;
                        q.offer(new int[]{rr, cc});
                    }
                }
            }
        }
        return visited[r-1][c-1];
    }
}
