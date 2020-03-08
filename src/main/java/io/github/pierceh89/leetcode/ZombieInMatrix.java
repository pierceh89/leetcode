package io.github.pierceh89.leetcode;

import io.github.pierceh89.ds.Tuple;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// https://leetcode.com/discuss/interview-question/411357/
// BFS solution
public class ZombieInMatrix {

    public static void main(String[] args) {
        ZombieInMatrix zim = new ZombieInMatrix();
        int result = zim.minHours(4, 5,
                Stream.of(
                        Arrays.asList(0, 1, 1, 0, 1),
                        Arrays.asList(0, 1, 0, 1, 0),
                        Arrays.asList(0, 0, 0, 0, 1),
                        Arrays.asList(0, 1, 0, 0, 0)).collect(Collectors.toList())
        );
        System.out.println("expected " + 2 + " result " + result);
    }

    int minHours(int rows, int columns, List<List<Integer>> grid) {
        int hours = 0;
        int human = 0;
        Queue<Tuple> queue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                int g = grid.get(i).get(j);
                if (g == 0) {
                    human++;
                } else if (g == 1) {
                    queue.offer(Tuple.of(i, j));
                }
            }
        }
        printMatrix(grid);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Tuple t = queue.poll();
                if (t.r - 1 >= 0 && grid.get(t.r - 1).get(t.c) == 0) {
                    human--;
                    grid.get(t.r - 1).set(t.c, 1);
                    queue.offer(Tuple.of(t.r - 1, t.c));
                }
                if (t.r + 1 < rows && grid.get(t.r + 1).get(t.c) == 0) {
                    human--;
                    grid.get(t.r + 1).set(t.c, 1);
                    queue.offer(Tuple.of(t.r + 1, t.c));
                }
                if (t.c - 1 >= 0 && grid.get(t.r).get(t.c - 1) == 0) {
                    human--;
                    grid.get(t.r).set(t.c - 1, 1);
                    queue.offer(Tuple.of(t.r, t.c - 1));
                }
                if (t.c + 1 < columns && grid.get(t.r).get(t.c + 1) == 0) {
                    human--;
                    grid.get(t.r).set(t.c + 1, 1);
                    queue.offer(Tuple.of(t.r, t.c + 1));
                }
            }
            printMatrix(grid);
            hours++;
            if (human == 0) break;
        }

        return hours;
    }

    void printMatrix(List<List<Integer>> grid) {
        int row = grid.size();
        int col = grid.get(0).size();
        for (int i=0; i < row; i++) {
            for (int j=0; j < col; j++) {
                System.out.print(grid.get(i).get(j) + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
}
