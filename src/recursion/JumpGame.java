package recursion;
//从0位置跳几次可以跳到最后的位置
public class JumpGame {
//    cur表示当前一步能跳到的最远位置
//    next表示下一步能跳到的最远位置
//    k表示需要几步能跳到最后位置
    public static  int jump(int arr[
            ])
    {
        int k=0;
        int cur=0;
        int next=0;
        for(int i=0;i<arr.length;i++)
        {
            if(i>cur)
            {
                k++;
                cur=next;
            }
            next=Math.max(next,arr[i]+i);
        }
        return  k;
    }
}
