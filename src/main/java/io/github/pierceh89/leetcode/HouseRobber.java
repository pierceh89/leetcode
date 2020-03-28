package io.github.pierceh89.leetcode;

/**
 * 192. HouseRobber
 * Step by Step DP solution from
 * https://leetcode.com/problems/house-robber/discuss/156523/From-good-to-great.-How-to-approach-most-of-DP-problems.
 */
public class HouseRobber {
    public int rob(int[] nums) {

        //step 2
        //return robRec(nums, nums.length-1);

        //step 3
        //int[] memo = new int[nums.length];
        //Arrays.fill(memo, -1);
        //return robMemo(nums, memo, nums.length-1);

        //step 4
        //return robIter(nums);

        //step 5
        return robIterConstant(nums);
    }

    private int robRec(int[] nums, int i) {
        if (i < 0) {
            return 0;
        }
        return Math.max(robRec(nums, i-2) + nums[i], robRec(nums, i-1));
    }

    private int robMemo(int[] nums, int[] memo, int i) {
        if (i < 0) {
            return 0;
        }
        if (memo[i] >= 0) {
            return memo[i];
        }

        int result = Math.max(robMemo(nums, memo, i-2) + nums[i], robMemo(nums, memo, i-1));
        memo[i] = result;
        return result;
    }

    private int robIter(int[] nums) {
        if (nums.length == 0) return 0;
        int[] memo = new int[nums.length + 1];
        memo[0] = 0;
        memo[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];
            memo[i+1] = Math.max(memo[i], memo[i-1] + val);
        }
        return memo[nums.length];
    }

    private int robIterConstant(int[] nums) {
        if (nums.length == 0) return 0;
        int prev2 = 0;
        int prev1 = 0;
        for(int n : nums) {
            int tmp = prev1;
            prev1 = Math.max(prev2 + n, prev1);
            prev2 = tmp;
        }
        return prev1;
    }
}
