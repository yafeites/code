package problems;

public class RelocateLinkedList {
    public  static  void relocate(Node head)
    {
        if(head==null||head.next==null)
        {
            return;
        }
        Node slow=head;
//        先将fast向后移一个的好处是不管指针的长度奇偶得到的slow的下一个指针必定是中间位置或者中间位置的下一个位置
        Node fast=head.next;
        while (fast.next!=null||fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;

        }
        Node right=slow.next;
        Node left=head;
        slow.next=null;
        merge(left,right);
    }

    private static void merge(Node left, Node right) {
        Node rightnext=null;
        while (left.next!=null)
        {
//            rightnext指向右指针的下一个
            rightnext=right.next;
//            右指针的下一个等于左指针的下一个
            right.next=left.next;
//            左指针的下一个等于右指针
            left.next=right;
//            左指针移到下一个遍历的位置
            left=right.next;
//            再将右指针指向右块的下一个遍历的位置
            right=rightnext;
        }
//        如果指针个数是奇数,那最后还剩余一个指针left指向他
        left.next=right;
    }
}
