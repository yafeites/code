package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: code
 * @description: LeetCode1248
 * @author: Mr.Wang
 * @create: 2020-04-27 19:26
 **/

public class CountNumberOfNiceSubarrays {
    public static void main(String[] args) {
        CountNumberOfNiceSubarrays c=new CountNumberOfNiceSubarrays();
        c.numberOfSubarrays(new int[]{2,2,2,1,2,2,1,2,2,2},2);
    }
        /**
        * @Description: 数学法
        * @Param:
        * @return:
        * @Author: Mr.Wang
        * @Date: 2020/4/27
        */
    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer,Integer>map=new HashMap<>();
        map.put(0,-1);
        int cnt=0;
        for(int i=0;i<nums.length;i++)
        {
            if((nums[i]&1)==1)
            {
                map.put(++cnt,i);
            }
        }
        map.put(++cnt,nums.length);
        int res=0;
        for(int i=1;i+k-1<cnt;i++)
        {
            res+=(map.get(i)-map.get(i-1))*(map.get(i+k)-map.get(i+k-1));
        }
        return res;
    }
        /**
        * @Descripion: 前缀方法
        * @Param:
        * @return:
        * @Author: Mr.Wang
        * @Date: 2020/4/27
        */
    public int numberOfSubarrays1(int[] nums, int k) {
        // 数组 prefixCnt 的下标是前缀和（即当前奇数的个数），值是前缀和的个数。
        int[] prefixCnt = new int[nums.length + 1];
        prefixCnt[0] = 1;
        // 遍历原数组，计算当前的前缀和，统计到 prefixCnt 数组中，
        // 并且在 res 中累加上与当前前缀和差值为 k 的前缀和的个数。
        int res = 0, sum = 0;
        for (int num: nums) {
            sum += num & 1;
            prefixCnt[sum]++;
            if (sum >= k) {
                res += prefixCnt[sum - k];
            }
        }
        return res;
    }


}
