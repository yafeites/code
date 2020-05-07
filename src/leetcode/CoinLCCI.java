package leetcode;

/**
 * @program: code
 * @description: LeetCode 面试08.11
 * @author: Mr.Wang
 * @create: 2020-04-29 18:54
 **/

public class CoinLCCI {
    public int waysToChange(int n) {
            /**
            * @Description: 正常的dp如果以硬币个数作为外层会导致计算多余的数量,因为不同硬币累加没有顺序性例如6=5+1=1+5会算成两种方法
             * 正确的方法是将不同硬币的种类放在外层，这样能保证方法的不同硬币的顺序性
            * @Param: [n]
            * @return: int
            * @Author: Mr.Wang
            * @Date: 2020/4/29
            */
        int []help=new int[]{1,5,10,25};
        int []dp=new int[n+1];
        dp[0]=1;
        for(int i:help)
        {
            for(int j=i;j<=n;j++)
            {
                dp[j]=(dp[j-i]+dp[j])%1000000007;
            }
        }
        return dp[n];
    }
}
