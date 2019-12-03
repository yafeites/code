package Tree;

import com.sun.org.apache.regexp.internal.RE;
import problems.Node;

//将有序数组转换成平衡二叉树
public class SortedArrayToBalancedBST {
    public  static Node Array2B_Tree(int arr[])
    {
        if(arr==null||arr.length==0)
        {
            return null;
        }
        return generate(arr,0,arr.length);
    }

    private static Node generate(int[] arr, int L, int R) {
        if(L>R)
        {
            return null;
        }
        int mid=(L+R)>>1;
        int value=arr[mid];
        Node res=new Node(value);
        res.left=generate(arr,0,mid-1);
        res.right=generate(arr,mid+1,R);
        return res;
    }

}
