package leetcode;

/**
 * @program: code
 * @description: LeetCode55
 * @author: Mr.Wang
 * @create: 2020-04-17 15:30
 **/

public class JumpGame {
    public boolean canJump(int[] nums) {
        int max=0;
        if(nums==null||nums.length==0)
        {
            return false;
        }
        for(int i=0;i<nums.length;i++)
        {
            if(i>max)
            {
                return false;
            }
            max=Math.max(max,i+nums[i]);
            if(max>=nums.length-1)
            {
                return true;
            }
        }
        return false;
    }
}
