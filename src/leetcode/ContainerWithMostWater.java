package leetcode;

/**
 * @program: code
 * @description: LeetCode11
 * @author: Mr.Wang
 * @create: 2020-04-22 18:33
 **/

public class ContainerWithMostWater {
    public static void main(String[] args) {
        ContainerWithMostWater containerWithMostWater=new ContainerWithMostWater();
        containerWithMostWater.maxArea(new int[]{1,8,6,2,5,4,8,3,7});
    }
        /**
        * @Description: 双指针法，从最小的一边开始移动指针，原因是如果移动另外一端会导致肯定比不移动的值小
        * @Param:
        * @return:
        * @Author: Mr.Wang
        * @Date: 2020/4/22
        */
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int res=0;
        while(left<right)
        {
            res=Math.max(Math.min(height[left],height[right])*(right-left),res);
            if(height[left]<height[right])
            {
                left++;
            }
            else
            {
                right--;
            }
        }
        return res;

    }
}
