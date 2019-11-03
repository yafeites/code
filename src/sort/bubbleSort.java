package sort;

public class bubbleSort {
//    public static void main(String[] args) {
//        int []arr=new int[]{7,6,5,4,3,2,1};
//        sort(arr);
//        System.out.println(Math.random());
//        for(int i=0;i<arr.length;i++)
//        {
//            System.out.println(arr[i]);
//        }
//
//    }
    public static void  sort(int arr[])
    {
        if(arr==null&&arr.length<2)
        {
            return;
        }
        for(int end=arr.length-1;end>0;end--)
        {
            for(int i=0;i<end;i++)
            {
                if(arr[i]>arr[i+1])
                {
                    function.swap(arr,i,i+1);
                }
            }
        }

    }
}
