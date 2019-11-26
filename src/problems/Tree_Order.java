package problems;

import javax.swing.tree.TreeNode;
import java.util.Stack;

public class Tree_Order {

    public static void main(String[] args) {
        Node node1=new Node(3);
        Node node2=new Node(4);
        Node node3=new Node(5);
        Node node4=new Node(6);
        Node node5=new Node(2);

        node1.left=node5;
        node1.right=node3;
        node3.left=node2;
        node3.right=node4;
        inOrderRecur(node1);
//        while (prenode!=null)
//        {
//            System.out.println(prenode.value);
//            prenode=prenode.left;
//        }

    }
//    static  Node prenode=null;
//    递归先序
    public  static  void preOrderRecur(Node node)
    {
        if(node==null)
        {
            System.out.println(node.value);
        }
        preOrderRecur(node.left);
        preOrderRecur(node.right);
    }
//    先序遍历的非递归实现
//      每次从stack中取出node,然后每次将其的右结点和左结点加入到stack中
    public  static  void preOrederUnRecur(Node node)
    {
        if (node != null) {

            Stack<Node> stack=new Stack<>();
            stack.add(node);
           while (!stack.empty())
           {
               node=stack.pop();
               System.out.println(node.value);
               if(node.right!=null)
               {
                   stack.push(node.right);
               }
               if(node.left!=null)

               {
                   stack.push(node.left);
               }
           }
        }
    }
//    递归中序
    public  static void inOrderRecur(Node node)
    {
        if(node==null)
        {
            return;
        }
        inOrderRecur(node.left);
//        if(prenode!=null)
//        {
//            prenode.right=node;
//        }
//        node.left=prenode;
//        prenode=node;
//        System.out.println(node.value);

        inOrderRecur(node.right);
    }
//    中序的非递归实现
//      每次将node的左结点加入stack中一旦左子结点为null则输出并将其右子结点加入
    public  static  void inOrderUnRecur(Node node)
    {
        Stack<Node> stack=new Stack<>();
        stack.add(node);
        while (stack.isEmpty()||node!=null)
        {
            if(node!=null)
            {
                stack.push(node);
                node=node.left;
            }
            else
            {
                node=stack.pop();
                System.out.println(node.value);
                node=node.right;
            }
        }
    }
//    递归后序
    public  static  void posOrderRecur(Node node)
    {
        if(node==null)
        {
            return;
        }
        posOrderRecur(node.left);
        posOrderRecur(node.right);
        System.out.println(node.value);
    }
//    后序非递归实现
//    每次从stack中取出node,将取出的node放入另一个stack中，然后每次将其的左结点和右结点加入到stack中。
//     主要意思就是将中右左结构从另一个stack转变成左右中结构。
     public static  void posOrderUnRecur(Node node)
     {
         if (node != null) {
             Stack<Node> stack=new Stack<>();
             Stack<Node> help=new Stack<>();
             stack.add(node);
             while (!stack.empty())
             {
                node= stack.pop();
                help.add(node);
                 if (node.left != null) {
                     stack.add(node.left);
                 }
                 if(node.right!=null)
                 {
                     stack.add(node.right);
                 }

             }

         }
     }
}
