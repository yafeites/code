package problems;

import java.util.HashMap;
import java.util.Map;

public class CopyList {
//    通过hashmap的方法添加CopyNode
    public  static Node CopyListWithRand1(Node head)
    {
        Map<Node,Node> map=new HashMap();
        Node cur=head;
        while (cur!=null)
        {
            map.put(cur,new Node(cur.value));
            cur=cur.next;
        }
        cur=head;
        while (cur!=null)
        {
            map.get(cur).next=map.get(cur.next);
            map.get(cur).rnd=map.get(cur.rnd);
            cur=cur.next;
        }
        return map.get(head);
    }
//    通过在原链表各节点后添加copy节点的方法构造CopyNode.
    public static Node copyListWithRand2(Node head)
    {
        if(head==null)
        {
            return  null;
        }
        Node cur=head;
        Node next=null;
        while (cur!=null)
        {
            next=cur.next;
            cur.next=new Node(cur.value);
            cur.next.next=next;
            cur=next;
        }
        cur=head;
        while (cur!=null)
        {
            next=cur.next;
            next.rnd=cur.rnd!=null? cur.rnd.next :null;
            cur=next.next;
        }
        cur=head;
        Node res=cur.next;
        while (cur != null)
        {
            next=cur.next;
            cur.next=next.next;
            next.next=cur.next!=null?cur.next:null;
            cur=cur.next;
        }
        return  res;
    }
}
