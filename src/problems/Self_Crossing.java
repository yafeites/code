package problems;
//每个4歩向上左下右移动看是否会有交叉
public class Self_Crossing {
    public  static  boolean ifSelfCrossing(int []arr)
    {
        if(arr==null||arr.length<=3)
        {
            return  false;
        }
        if(arr.length>3&&arr[3]>=arr[1]&&arr[2]<=arr[0])
        {
            return true;
        }
        if(arr.length>4&&((arr[3]<arr[1]&&arr[4]>=arr[2])||(arr[4]+arr[0]>=arr[2]&&arr[3]==arr[1])))
        {
            return  true;
        }
        for(int i=5;i<arr.length;i++)
        {
            if(arr[i-1]<=arr[i-3]&&(arr[i]>=arr[i-2]||
                    (arr[i-5]>arr[i-3]-arr[i-1]&&arr[i]>=arr[i-2]-arr[i-4]&&arr[i-2]>=arr[i-4])))
            {
                    return  true;
            }
        }
        return  false;
    }
}
