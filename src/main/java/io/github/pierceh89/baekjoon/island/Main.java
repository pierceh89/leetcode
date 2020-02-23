package io.github.pierceh89.baekjoon.island;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main ic = new Main();
        Scanner sc = new Scanner(System.in);
        while (true){
            int w, h;
            w = sc.nextInt();
            h = sc.nextInt();
            if (w == 0 && h == 0) {
                break;
            }
            int[][] grid = new int[h][w];
            for (int i=0; i <h; i++) {
                for (int j=0; j<w; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            System.out.println(ic.islandCount(grid));
        }
    }

    public static class Tuple {
        int r;
        int c;
        public static Tuple of(int r, int c) {
            Tuple t = new Tuple();
            t.r = r;
            t.c = c;
            return t;
        }
    }

    public int islandCount(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        Queue<Tuple> queue = new LinkedList<>();
        int[][] visited = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j=0; j < col; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(Tuple.of(i, j));
                }
            }
        }
        int count = 0;
        while(!queue.isEmpty()) {
            Tuple t = queue.poll();
            if (visited[t.r][t.c] == 1) {
                continue;
            }
            findIsland(grid, visited, t.r, t.c, row, col);
            count++;
        }
        return count;
    }

    public void findIsland(int[][] grid, int[][] visited, int i, int j, int row, int col) {
        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
        Queue<Tuple> q = new LinkedList<>();
        q.offer(Tuple.of(i, j));
        while(!q.isEmpty()) {
            Tuple t = q.poll();
            int r = t.r;
            int c = t.c;
            visited[r][c] = 1;
            for (int idx=0; idx < dr.length; idx++) {
                int rr = r + dr[idx];
                int cc = c + dc[idx];
                if (rr >= 0 && rr < row && cc >= 0 && cc < col && grid[rr][cc] == 1 && visited[rr][cc] == 0) {
                    visited[rr][cc] = 1;
                    q.offer(Tuple.of(rr, cc));
                }
            }
        }
    }
}
