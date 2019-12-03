package Linkedlist;

import problems.Node;

public class getIntersectNode {

    //寻找两个可能带环链表的第一个公共节点
    public static Node getIntersectNode(Node head1, Node head2)
    {
//      首先对链表1和链表2通过快慢指针进行判断是否为带环链表,如果都为带环链表和都不为带环链表处理方式不同,
//        并且其他情况不可能有公共节点.
        if (head1 == null || head2 == null) {
            return null;
        }
        Node loop1=getLoopNode(head1);
        Node loop2=getLoopNode(head2);
        if(loop1==null&&loop2==null)
        {
        }
        else if (loop2 != null && loop1 != null) {
            return bothloop(head1,loop1,head2,loop2);
        }
        return  null;
    }

    private static Node noloop(Node head1, Node head2) {
        //对于不带环节点,我们可以判断链表长度差,让长链表先移动差值再搜寻公共节点
        int length1=1;
        int length2=1;
        Node cur1=head1;
        Node cur2=head2;
        while (cur1.next!= null) {
            cur1=cur1.next;
            length1++;
        }
        while (cur2.next!= null) {
            cur2=cur2.next;
            length2++;
        }
        if(length1>length2)
        {
            int dis=length1-length1;
            while (dis!=0)
            {
                head1= head1.next;
            }

        }
        if(length2>length1)
        {
            int dis =length2-length1;
            while (dis!=0)
            {
                head2=head2.next;
            }

        }
        while (head1 != head2) {

            head1=head1.next;
            head2=head2.next;
        }
        return  head1;

    }

    private static Node bothloop(Node head1, Node loop1, Node head2, Node loop2) {
//        对于带环链表存在2中情况:
//        1.相遇在未进入环之前的位置,那处理方法和非带链表一样只是最终节点从null变成了两个环的入口
//        2.相遇在环内的位置,判断链表1的入口向后移动以后,是否可以找到loop2节点.
        if (loop1 == loop2) {
            Node cur1=head1;
            Node cur2=head2;
            int n=0;
            while (cur1!=loop1)
            {
                n++;
                cur1=cur1.next;
            }
            while (cur2!=loop2)
            {
                n--;
                cur2=cur2.next;
            }
            cur1=n>0? head1:head2;
            cur2=cur1==head1? head2:head1;
            while(n>0)
            {
                cur1=cur1.next;
            }
            return cur1;
        }
        else
        {
            Node cur1=loop1.next;
            while (cur1!=loop1)
            {
                if(cur1==loop2)
                {
                    return loop1;
                }
                cur1=cur1.next;
            }
            return  null;
        }
    }

    private static Node getLoopNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node n1 = head.next; // n1 -> slow
        Node n2 = head.next.next; // n2 -> fast
        while (n1 != n2) {
            if (n2.next == null || n2.next.next == null) {
                return null;
            }
            n2 = n2.next.next;
            n1 = n1.next;
        }
        n2 = head; // n2 -> walk again from head
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }
}

