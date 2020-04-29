package io.github.pierceh89.leetcode;

/**
 * Leetcoding Challenge Week4 Day4
 */
public class CanJump {
    public boolean canJump(int[] nums) {
        int goal = nums.length-1;
        return check(nums, 0, goal);

    }

    public boolean check(int[] nums, int cur, int goal) {
        if (cur > goal) {
            return false;
        }
        if (cur == goal) {
            return true;
        }
        int val = nums[cur];
        if (val == 0) {
            return false;
        }
        for(int i=val; i>=1; i--) {
            if(check(nums, cur+i, goal)) {
                return true;
            }
        }
        return false;
    }
}
