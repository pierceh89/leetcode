package io.github.pierceh89.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
{ 1 2 3 }
{ 2 1 3 }
{ 3 2 1 }
{ 1 3 2 }
{ 2 3 1 }
{ 3 1 2 }
*/

/*
 *    The algroithm - Take each element in array to the first place.
 *
 *    For example:
 *
 *         0) initalization
 *
 *             pos = 0
 *             [1, 2, 3]
 *
 *         1) take each element into the first place,
 *
 *             pos = 1
 *             [1, 2, 3]  ==>  [2, 1, 3] , [3, 1, 2]
 *
 *             then we have total 3 answers
 *             [1, 2, 3],  [2, 1, 3] , [3, 1, 2]
 *
 *         2) take each element into the "first place" -- pos
 *
 *             pos = 2
 *             [1, 2, 3]  ==>  [1, 3, 2]
 *             [2, 1, 3]  ==>  [2, 3, 1]
 *             [3, 1, 2]  ==>  [3, 2, 1]
 *
 *             then we have total 6 answers
 *             [1, 2, 3],  [2, 1, 3] , [3, 1, 2], [1, 3, 2], [2, 3, 1], [3, 2, 1]
 *
 *          3) pos = 3 which greater than length of array, return.
 *
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> solutions = new ArrayList<>();
        List<Integer> initialSeq = Arrays.stream(nums).boxed().collect(Collectors.toList());
        solutions.add(initialSeq);
        if (nums.length < 2) {
            return solutions;
        }

        int pos = 0;
        while (pos < nums.length - 1) {
            int size = solutions.size();
            for (int i = 0; i < size; i++) {
                for (int j = pos + 1; j < solutions.get(i).size(); j++) {
                    List<Integer> s = new ArrayList<>(solutions.get(i));
                    int t = s.get(j);
                    s.set(j, s.get(pos));
                    s.set(pos, t);
                    solutions.add(s);
                }
            }
            pos++;
        }
        return solutions;
    }
}
