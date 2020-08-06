package io.github.pierceh89.leetcode.topinterviewquestions;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * https://leetcode.com/explore/featured/card/top-interview-questions-easy/98/design/670/
 * If we put each number in a "hat" and draw them out at random,
 * the order in which we draw them will define a random ordering.
 */
public class ShuffleAnArray {
    int[] original;

    private Random random = new Random();

    public ShuffleAnArray(int[] nums) {
        original = nums.clone();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return original;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] ret = new int[original.length];
        List<Integer> nums = getList();
        for(int i=0; i<ret.length; i++) {
            int removeIdx = random.nextInt(nums.size());
            ret[i] = nums.get(removeIdx);
            nums.remove(removeIdx);
        }
        return ret;
    }

    private List<Integer> getList() {
        List<Integer> ret = new ArrayList<>();
        for(int i=0; i < original.length; i++) {
            ret.add(original[i]);
        }
        return ret;
    }
}
