package arr;
//求数组中子数组和的最大值
public class SubArrayMaxSum {
//    从数组第一个判断,如果当前累加和小于0则重置为0,并用max存储最大累加和
    public  static int maxSubArray(int arr[])
    {
        if(arr.length==0)
        {
            return 0;
        }
        int cur=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++)
        {
                cur+=arr[i];
                max=Math.max(cur,max);
                cur=cur<0? 0:cur;
        }
        return  max;
    }
}
