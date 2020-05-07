package leetcode;

/**
 * @program: code
 * @description: LeetCode887
 * @author: Mr.Wang
 * @create: 2020-04-25 20:07
 **/

public class SuperEggDrop {
    public static void main(String[] args) {
        SuperEggDrop superEggDrop=new SuperEggDrop();
        superEggDrop.superEggDrop(2,6);
    }
        /**
        * @Description: dp做,对于k个鸡蛋和n层，如果从某一层p开始尝试如果碎了肯定在1到p-1层,如果没碎在p+1到n层找即
         * Math(dp[p-1][k-1],dp[n-p][k]),然后对于每一层当作初始扔鸡蛋层遍历即可,由于从定性分析来看,k不变n增大移动层数增多,n不变k增大移动层数减少
         * 又由于当p=1 dp[p-1][k-1]-dp[n-p][k]小于0,p=n,dp[p-1][k-1]-dp[n-p][k]大于0所以肯定存在两个位置是离0最近的，用二分法找到这两个邻接位置比较即可不用第三层遍历了
        * @Param:
        * @return:
        * @Author: Mr.Wang
        * @Date: 2020/4/25
        */
    public int superEggDrop(int K, int N) {
        int dp[][]=new int[N+1][K+1];
        for(int i=1;i<=K;i++)
        {
            dp[1][i]=1;
        }
        for(int i=1;i<=N;i++)
        {
            dp[i][1]=i;
        }
        for(int i=2;i<=N;i++)
        {
            for(int j=2;j<=K;j++)
            {

//                    随着k增大dp[k-1][j-1]变大 dp[i-k][j]变小,dp[k-1][j-1]-dp[i-k][j]变大
                int left=1;
                int right=i;
                while (left<right)
                {
                    int mid=(left+right)>>1;
                    if(dp[mid-1][j-1]-dp[i-mid][j]<0)
                    {
                        left=mid+1;
                    }
                    else {
                        right = mid;
                    }
                }
                dp[i][j]=Math.min(Math.max(dp[left-1][j-1],dp[i-left][j]),Math.max(dp[left-2][j-1],dp[i-left+1][j]))+1;

            }
        }
        return dp[N][K];
    }
}

