package io.github.pierceh89.leetcode;

/**
 * 283. Move Zeros
 */
class MoveZeros {
	public void moveZeroesSolution(int[] nums) {
        int lastNonZeroFoundAt=0;
        for(int i=0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[lastNonZeroFoundAt++] = nums[i];
            }
        }
        for(int i=lastNonZeroFoundAt; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
    // my solution (look messy)
    public void moveZeroes(int[] nums) {
        for(int i=0; i<nums.length-1; i++) {
            if(nums[i] == 0) {
                int j=i+1;
                while(j < nums.length) {
                    if(nums[j] != 0) {
                        break;
                    }
                    j++;
                }
                //switch
                if(j < nums.length) {
                    nums[i] = nums[j];
                    nums[j] = 0;
                    
                }
            }
        }
    }
}
