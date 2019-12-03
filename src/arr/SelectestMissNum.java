package arr;

import static sort.function.swap;
//找到数组中下一个最小的整数
public class SelectestMissNum {
    public  static  int missNum(int []arr)
    {
//        L左边为对应索引为i对应值为i+1的局面,R为目前还可能达到的从0开始最大排好序的长度减2
        int L=0;
        int R=arr.length-1;
        while (L<=R)
        {
            if(arr[L]==L+1)
            {
                L++;
            }
            else if(arr[L]<L+1||arr[L]>R+1||arr[L]==arr[arr[L]-1])
            {
                arr[L]=arr[R--];
            }
            else {
                swap(arr,L,arr[L]-1);
            }
        }
        return  L+1;
    }
}
