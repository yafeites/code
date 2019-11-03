package recursion;
//给定一个数组,判断是否有机会使得数组中的数字和aim
public class Money_Problem {
    public static boolean money1(int arr[],int aim)
    {
        return  process1(arr,0,0,aim);
    }

    private static boolean process1(int[] arr, int i, int sum, int aim) {
        if(sum==aim)
        {
            return  true;
        }
        return process1(arr,i+1,arr[i]+sum,aim)||process1(arr,i+1,arr[i],aim);
    }
//    我们维持一个二维数组,横坐标为遍历过几个数字,纵坐标为目前到达的值
//      递归中变的为i和sum即为动态规划的两个坐标,已知在纵坐标为aim的情况下返回的肯定为true
    private static boolean money2(int arr[],int aim)
    {
        boolean [][]dp=new boolean[arr.length+1][aim+1];
        for(int i=0;i<arr.length;i++)
        {
            dp[i][aim]=true;
        }
        for(int i=dp.length-2;i>=0;i--)
        {
            for(int j=dp[0].length-1;j>=0;j--)
            {
                dp[i][j]=dp[i+1][j];
                if(j+arr[j]<=aim)
                {
                    dp[i][j]=dp[i][j]||dp[i+1][j+arr[j]];
                }
            }
        }
        return  false;

    }
}
