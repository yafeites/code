package sort;

public class partitionSort {
    public static void main(String[] args) {
        int []arr=new int[]{7,6,5,4,3,2,1};
        sort(arr);
        System.out.println(Math.random());
        for(int i=0;i<arr.length;i++)
        {
            System.out.println(arr[i]);
        }

    }
    public  static  void sort(int arr[])

    {
        if(arr==null&&arr.length<2)
        {
            return;
        }
        quickSort(arr,0,arr.length-1);
    }

    private static void quickSort(int[] arr, int L, int R) {
        if(L<R)
        {
            function.swap(arr,L+(int)(Math.random()*(R-L+1)),R);
            int p[]=partition(arr,L,R);
            quickSort(arr,L,p[0]);
            quickSort(arr,p[1],R);
        }
        //随机选择数组中的元素，放置出现由于基数非靠近数组中位数的值而导致的O（n^2)时间复杂度

    }

    private static int[] partition(int[] arr, int l, int r) {
        int less=l-1;
        int more=r;
        //判断指针l是否小于最右边的大区域界限位置
        while (l<more)
        {
//            如果指针l是小于快排的基数，我们将l位置的值与最左边小区域界限右边的值进行调换；
            if(arr[l]<arr[r])
            {
                function.swap(arr,++less,l++);
            }
//            如果指针l大于快排基数，我们将l位置的值与最右边大区域界限左边的值进行调换，
//            并且由于被大区域边界左侧的值并没有被遍历过，所以指针l不++;
            else if(arr[l]>arr[r])
            {
                function.swap(arr,--more,l);
            }
            else
            {
                l++;
            }

        }
        function.swap(arr,more,r);
        return new int[]{less,more+1};
    }
}
