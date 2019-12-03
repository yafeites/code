package problems;

import java.lang.reflect.Array;
import java.util.Arrays;
//找寻数组中第k大的数
//bfprt算法首先寻找数组中的中位数然后再将此中位数作为标志位进行快排处理
public class BFPRT {
    public  static  int bfprt(int arr[],int k)
    {
        int[] copyArr = copyArray(arr);
        return select(copyArr, 0, copyArr.length - 1, k - 1);


    }
//      取最小k个数的核心算法入口
    private static int select(int[] copyArr, int begin, int end, int k) {
        if(begin==end)
        {
            return begin;
        }
//        取得数组从begin到end的中位标志数字
        int pivot=getmidnum(copyArr,begin,end);
//          利用快排处理查看k是否在快排数组中和中位标识数相等的范围内
        int []range=partition(copyArr,begin,end,pivot);
        if(range[0]<=k&&range[1]>=k)
        {
            return  range[0];
        }
//        如果不在根据k的位置进行下次递归
        else if(range[0]>k)
        {
            return select(copyArr,begin,range[0]-1,k);
        }
        else
            return  select(copyArr,range[1]+1,end,k);
    }


    public static int[] copyArray(int[] arr) {
        int[] res = new int[arr.length];
        for (int i = 0; i != res.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }
    public  static  int  getmidnum(int arr[],int begin,int end)
    {
        int num=end-begin+1;
          int offset=num%5==0? 0:1;
        int res[]=new int[num/5+offset];
        for(int i=0;i<arr.length;)
        {
                int beginI=begin+i*5;
                int endI=i+4;
                res[i]=getmid(arr,beginI,Math.min(endI,end));
        }
//              利用select方法求begin到end的中位位置
        return  select(res,0,res.length-1,(res.length-1)/2);
    }
    public static  int  getmid(int arr[],int begin,int end)
    {
            Arrays.sort(arr,begin,end);
            return arr[(begin+end)/2];
    }

    private static int[] partition(int[] arr, int i, int j, int flag) {
        int left=i-1;
        int right=j+1;
        while (i<right)
        {
            if(arr[i]<flag)
            {
                swap(arr,i++,++left);

            }
            else if(arr[i]>flag)
            {
                swap(arr,i,--right);

            }
            else
            {
                i++;
            }
        }
            int res[]=new int[2];
        res[0]=left+1;
        res[1]=right-1;
        return  res;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
