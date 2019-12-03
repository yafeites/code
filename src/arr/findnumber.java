package arr;
//数组从左到右呈现递增趋势,从上到下呈现递增趋势,找寻是否存在target
public class findnumber {
    public static boolean findnumber(int arr[][],int target)
    {
        if(arr.length==0||arr==null)
        {
            return false;
        }
        int i=0;
        int j=arr[0].length-1;
        while (i<arr.length&&j>=0)
        {
            if(arr[i][j]==target)
            {
                return true;
            }
            else if(arr[i][j]>target)
            {
                j--;
            }
            else
            {
                i++;
            }
        }
        return false;
    }
}
