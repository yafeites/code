package sort;

public class MergeSort {
    public static void sort(int arr[])
    {
        if(arr==null&&arr.length<2)
        {
            return;
        }
        sortProcess(arr,0,arr.length-1);

    }

    private static void sortProcess(int[] arr, int L, int R) {
        if(L==R)
        {
            return;
        }
        int mid=L+((R+L)>>1);
        sortProcess(arr,L,mid);
        sortProcess(arr,mid+1,R);
        merge(arr,L,mid,R);
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int p[]=new int[r-l+1];
        int i=0;
        int p1=l;
        int p2=mid+1;
        while (p1<=mid&&p2<r+1)
        {
            if(arr[p1]<arr[p2])
            {
                p[i]=arr[p1];
                p1++;
            }
            else
            {
                p[i]=arr[p2];
                p2++;
            }
            i++;

        }
        while (p1<=mid)
        {
            arr[p1]=p[i];
            i++;
            p1++;
        }
        while (p2<=r)
        {
            arr[p2]=p[i];
            i++;
            p2++;
        }
        for(i=0;i<p.length;i++)
        {
            arr[i+l]=p[i];
        }
    }
}
