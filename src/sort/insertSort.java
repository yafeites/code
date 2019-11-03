package sort;

public class insertSort {
    public static void sort(int arr[])
    {
        if(arr==null&&arr.length<2)
        {
            return;
        }
        for(int i=1;i<arr.length;i++)
        {
            for(int j=i-1;j>=0&&arr[j]>arr[j+1];j--)
            {
                function.swap(arr,i,j);
            }
        }
    }
}
