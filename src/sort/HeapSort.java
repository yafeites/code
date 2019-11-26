package sort;
//堆排序不稳定+常数项比较大
public class HeapSort {
    public static void sort(int arr[])
    {
        if(arr==null&&arr.length<2)
    {
        return;
    }
        for(int i=1;i<arr.length;i++)
        {
            heapInsert(arr,i);
        }
        int heapSize=arr.length;
//        每次将最大值的节点与数组中最后的数值进行交换，并且将调上来的数进行下调
        function.swap(arr,0,--heapSize);
        while(heapSize>0)
        {
            heapify(arr,0,heapSize);
            function.swap(arr,0,--heapSize);
        }
    }

    private static void heapify(int[] arr, int i, int heapSize) {
        int left=i*2+1;
//        判断是否i的左孩子存在
        while (left < heapSize) {
//            判断孩子中值最大的结点的下表
            int largest=left+1<heapSize&&arr[left]<arr[left+1]? left+1:left;
//            如果最大子结点大于i结点的值则与孩子交换
            largest=arr[largest]>arr[i]? largest:i;
            if(largest==i)
            {
                break;
            }
            function.swap(arr,largest,i);
            i=largest;
            largest=2*i+1;
        }
    }

    private static void heapInsert(int[] arr, int i) {
//        判断新加入堆的元素是否大于其父节点,大于则一直上调
        while (arr[i]>arr[(i-1)/2])
        {
            function.swap(arr,i,(i-1)/2);
            i=(i-1)/2;
        }
    }


}
