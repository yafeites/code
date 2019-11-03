package problems;

public class maxGap {
//    从n个数之间找到相邻2个数字的最大差值
    public static void main(String[] args) {
//        System.out.println(maxgap(new int[]{0,51,199}));
        System.out.println(maxGap(new int[]{0,51,199}));

    }

    public static int maxGap(int[] nums){
        if(nums==null||nums.length<2)   return 0;
        int len=nums.length;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        //找出数组中的最大数和最小数
        for (int i = 0; i < len; i++) {
            min=Math.min(min,nums[i]);
            max=Math.max(max,nums[i]);
        }
        //如果数组中只有一种数字，直接返回
        if(min==max)    return 0;
        //记录是否是空桶，true表示不是空桶
        boolean[] hasNum=new boolean[len+1];
        //记录每个桶的最大值和最小值
        int[] maxs=new int[len+1];
        int[] mins=new int[len+1];
        int bid=0;
        for (int i = 0; i < len; i++) {
            bid=bucket(nums[i],len,min,max);
            mins[bid]=hasNum[bid]?Math.min(mins[bid],nums[i]):nums[i];
            maxs[bid]=hasNum[bid]?Math.max(maxs[bid],nums[i]):nums[i];
            hasNum[bid]=true;
        }
        int res=0;
        int lastMax=maxs[0];
        int i=1;
        //找一个非空桶及离它最近的非空桶，后桶的最小值减去前桶的最大值，找出最大差值
        for (; i <=len ; i++) {
            if(hasNum[i]){
                res=Math.max(res,mins[i]-lastMax);
                lastMax=maxs[i];
            }
        }
        return res;
    }
    //当前数字属于几号桶
    public static int bucket(long num,long len,long min,long max){
        return (int)((num-min)*len/(max-min));
    }
//    public static int maxgap(int []arr)
//    {
//        if(arr==null||arr.length==0)
//        {
//            return 0;
//        }
//        int len=arr.length;
//        int min=Integer.MIN_VALUE;
//        int max=Integer.MIN_VALUE;
//        for(int i=0;i<arr.length;i++)
//        {
//            min=Math.min(min,arr[i]);
//            max=Math.max(max,arr[i]);
//        }
//        if (min == max) {
//            return 0;
//        }
//        boolean[]hasNum=new boolean[len+1];
//        int []maxs=new int[len+1];
//        int []mins=new int[len+1];
//        int bid=0;
//        for(int i=0;i<len;i++)
//        {
//            bid=bucket(arr[i],len,min,max);
//            mins[bid]=hasNum[bid]? Math.min(mins[bid],arr[i]):arr[i];
//            maxs[bid]=hasNum[bid]? Math.min(maxs[bid],arr[i]):arr[i];
//            hasNum[bid]=true;
//        }
//        int res=0;
//        int lastMax=maxs[0];
//        int i=1;
//        for(;i<=len;i++)
//        {
//            if(hasNum[i])
//            {
//                res=Math.max(res,mins[i]-lastMax);
//                lastMax=maxs[i];
//            }
//        }
//            return  res;
//
//    }
//
//    public static int bucket(long num,long len,long min ,long max)
//    {
//     return (int)((num-min)*len/(max-min));
//    }
}
