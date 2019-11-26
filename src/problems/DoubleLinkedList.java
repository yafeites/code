package problems;
//搜索树按值大小变成双向节点left指向小的值,right指向大的值
public class DoubleLinkedList {
    public  static  Node getDoubleLinkedListHead(Node node)
    {
        if(node!=null)
        {
           return process(node)[0];
        }
        return  null;
    }

    private static Node[] process(Node node) {
        if(node==null)
        {
            return new Node[]{null,null};
        }
        node.left=null;
        node.right=null;
        Node leftheads[]=process(node.left);
        Node rightheads[]=process(node.right);
        if (leftheads[1] != null) {

            node.left=leftheads[1];
            leftheads[1].right=node;
        }
        if(rightheads[1]!=null)

        {
            node.right=rightheads[0];
            rightheads[0].left=node;
        }
        return new Node[]{leftheads[0]==null?node:leftheads[0],rightheads[1]==null?node:rightheads[1]};
    }
}
