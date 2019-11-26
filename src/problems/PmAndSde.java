package problems;

//pm想做的事情按cost从小到大推荐给Sde
//Sde想做的事情按value从大到小进行选择 使用堆上堆结构
public class PmAndSde {
    private  static  class  PmNode
    {
        public  int cost;
        public  int value;

    }
    private static  class SdeNode extends  PmNode
    {
          PmNode node;
        public SdeNode(PmNode node,int index, int arrNum) {
           this.node=node;
            this.index = index;
            this.arrNum = arrNum;
        }

        public  int index;
        public  int arrNum;
    }
    public   static  void chooseFavouriteK(PmNode matrix[][],int topK)
    {
        int heapfysize=matrix.length;
        SdeNode[]arr=new SdeNode[heapfysize];
        for(int i=0;i<matrix.length;i++)
        {
//            循环遍历,每次将同一PM的Node按value进堆
            for(int j=0;i<matrix[j].length;j++)
            {
                heapInsertbyvalue(matrix[i],j);
            }
//            将建好堆的每个数组的第一个元素装饰成SdeNode放入arr中
            arr[i]=new SdeNode(matrix[i][0],0,i);
             heapInsertbycost(arr,i);
        }

        for(int k=0;k<topK;k++)
        {
            if(heapfysize==0)
            {
                break;
            }
            System.out.println(arr[0].index+"+"+arr[0].arrNum);
            if(arr[0].index==matrix[arr[0].arrNum].length-1)
            {
                swap(arr,0,--heapfysize);
            }
            else
            {
                arr[0].cost=matrix[arr[0].arrNum][++arr[0].index].cost;
                arr[0].value=matrix[arr[0].arrNum][arr[0].index+1].value;
            }
            heapifybycost(arr,0,heapfysize);

        }

    }
//    value大根堆
    private static void heapifybyvalue(SdeNode[] arr, int i, int heapSize) {
        int left=i*2+1;
//        判断是否i的左孩子存在
        while (left < heapSize) {
//            判断孩子中值最大的结点的下表
            int smallest=left+1<heapSize&&arr[left].node.value>arr[left+1].node.value? left+1:left;
//            如果最大子结点大于i结点的值则与孩子交换
            smallest=arr[smallest].node.value<arr[i].node.value? smallest:i;
            if(smallest==i)
            {
                break;
            }
            swap(arr,smallest,i);
            i=smallest;
            smallest=2*i+1;
        }
    }
//    cost小根堆
    private static void heapifybycost(SdeNode[] arr, int i, int heapSize) {
        int left=i*2+1;
//        判断是否i的左孩子存在
        while (left < heapSize) {
//            判断孩子中值最大的结点的下表
            int largest=left+1<heapSize&&arr[left].cost<arr[left+1].cost? left+1:left;
//            如果最大子结点大于i结点的值则与孩子交换
            largest=arr[largest].cost>arr[i].cost? largest:i;
            if(largest==i)
            {
                break;
            }
            swap(arr,largest,i);
            i=largest;
            largest=2*i+1;
        }
    }
    private  static  void swap(PmNode[] arr, int i, int j)
    {
        PmNode temp;
        temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }


    private static void heapInsertbycost(SdeNode[] arr, int i) {
        while (i!=0)
        {
            //        判断新加入堆的元素是否大于其父节点,大于则一直上调
            while (arr[i].cost>arr[(i-1)/2].cost)
            {
                swap(arr,i,(i-1)/2);
                i=(i-1)/2;
            }
        }
    }
    private static void heapInsertbyvalue(PmNode[] arr, int i) {
        while (i!=0)
        {
            //        判断新加入堆的元素是否大于其父节点,大于则一直上调
            while (arr[i].value<arr[(i-1)/2].value)
            {
                swap(arr,i,(i-1)/2);
                i=(i-1)/2;
            }
        }
    }

}
