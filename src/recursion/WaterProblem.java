package recursion;

public class WaterProblem {
    public  static  int getwater(int []arr)
    {
        if(arr==null||arr.length<3)

        {
            return 0;
        }
        int value=0;
        int n=arr.length-2;
        int[]rightmax=new int[n];
        rightmax[n-1]=arr[n+1];
        for(int i=n-2;i>=0;i--)
        {
               rightmax[i]=Math.max(rightmax[i+1],arr[i+2]);
        }
        int leftmax=arr[0];
       for(int j=1;j<=n;j++)
       {
           value+=Math.max(0,Math.min(leftmax,rightmax[j-1])-arr[j]);
           leftmax=Math.max(leftmax,arr[j]);
       }
     return value;
    }
//    每次从数组中第二个和倒数第二个位置开始判断,只要小于边界最小值即可以接到水,并且判断leftmax和rightmax的大小
//      从小的那一边开始下一次循环
    public  static int getWater2(int []arr)
    {
        if(arr==null||arr.length<3)
        {
            return 0;
        }
        int value=0;
        int leftmax=arr[0];
        int rightmax=arr[arr.length-1];
        int l=1;
        int r=arr.length-2;
        while (l<=r)
        {
            if(leftmax<=rightmax)
            {
                value+=Math.max(0,Math.min(leftmax,rightmax)-arr[l]);
                leftmax=Math.max(arr[l++],leftmax);
            }
            else
            {
                value+=Math.max(0,Math.min(leftmax,rightmax)-arr[r]);
                rightmax=Math.max(arr[r--],rightmax);
            }
        }
        return value;
    }
}
