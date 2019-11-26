package problems;

public class PostArrayToBST  {
    public  static  Node posToBST(int [] arr,int start,int end)
    {
        if(start<end)
        {
            return null;
        }
        Node head=new Node(arr[end]);
        int lessright=-1;
        int moreleft=end;
        for(int i=start;i<end;i++)
        {
            if(arr[i]<arr[end])
            {
                lessright=i;
            }
            else
            {
                moreleft=moreleft==end? i:moreleft;
            }
        }
        head.left=posToBST(arr,0,lessright);
        head.right=posToBST(arr,moreleft,end-1);
        return  head;
    }
    public  static boolean isbst(int[] arr)
    {
        if(arr.length==0||arr==null)
        {
            return  false;
        }
        else  return isPost(arr,0,arr.length-1);
    }
    //给定一个数组,判断是否为二叉搜索树的后序遍历
    private static boolean isPost(int[] arr, int start, int end) {
        if(start==end)
        {
            return  true;
        }
        int lessright=-1;
        int moreleft=end;
        for(int i=start;i<end;i++)
        {
            if(arr[i]<arr[end])
            {
                lessright=i;
            }
            else
            {
                moreleft=moreleft==end? i:moreleft;
            }
        }
        if(lessright==-1||moreleft==end)
        {
            return isPost(arr,start,end-1);
        }
        if(lessright!=moreleft-1)
        {
            return  false;
        }
        return  isPost(arr,start,lessright)&&isPost(arr,moreleft,end-1);
    }
}
