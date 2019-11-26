package problems;

import sort.function;
//已知有n个长度不同的排序数组,求所有数字中最大的K个数字
public class PrintMaxTopK {
    static  class  HeapNode{
        int value;
        int index;
        int arrNum;

        public HeapNode(int value, int index, int arrNum) {
            this.value = value;
            this.index = index;
            this.arrNum = arrNum;
        }
    }
    public  static  void printTopK(int [][]matrix,int topK)
    {
//        创造一个数组存放matrix长度的值
        int heapsize=matrix.length;
        HeapNode arr[]=new HeapNode[heapsize];
//        将每个数组的最后一个元素放入堆中
           for(int i=0;i<heapsize;i++)
           {
               int index=matrix[i].length-1;
               arr[i]=new HeapNode(matrix[i][index],index,i);
               heapInsert(arr,i);
           }
           for(int i=0;i<topK;i++)
           {
               if(heapsize==0)
               {
                   break;
               }
               System.out.println(arr[0].value);
//               每次将arr[0]的值换成其对应数组中前一个的值
//                 因为下一个最大的数字一定是堆中剩下的数字和arr[0]刚进来的数字中的某一个
               if(arr[0].index!=0)
               {
                   arr[0].value=matrix[arr[0].arrNum][--arr[0].index];
               }
//                如果arr[0]索引已经是0位置则将堆减小一个尺寸即可
               else
               {
                   swap(arr,0,--heapsize);
               }
//               不论是否减小堆尺寸,都需要将堆的头结点进行重新计算位置
               heapify(arr,0,heapsize);
           }

    }
    private static void heapify(HeapNode[] arr, int i, int heapSize) {
        int left=i*2+1;
//        判断是否i的左孩子存在
        while (left < heapSize) {
//            判断孩子中值最大的结点的下表
            int largest=left+1<heapSize&&arr[left].value<arr[left+1].value? left+1:left;
//            如果最大子结点大于i结点的值则与孩子交换
            largest=arr[largest].value>arr[i].value? largest:i;
            if(largest==i)
            {
                break;
            }
            swap(arr,largest,i);
            i=largest;
            largest=2*i+1;
        }
    }
    private  static  void swap(HeapNode[] arr,int i,int j)
    {
        HeapNode temp;
        temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    private static void heapInsert(HeapNode[] arr, int i) {
        while (i!=0)
        {
            //        判断新加入堆的元素是否大于其父节点,大于则一直上调
            while (arr[i].value>arr[(i-1)/2].value)
            {
                swap(arr,i,(i-1)/2);
                i=(i-1)/2;
            }
        }
        }

}
