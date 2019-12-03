package Linkedlist;

import problems.Node;

//判断序列是否为回文序列
public class Palindrome {

//    利用快慢指针找到中间位置,再将右侧链表反转,最后判断遍历左链表和右链表是否相等
    public  static   boolean isPalindrome(Node head)
    {
      if(head==null ||head.next==null)
      {
          return true;
      }
      Node slow=head;
      Node fast=head;
      while (fast.next!=null&&fast.next.next!=null)
      {
          slow=slow.next;
          fast=fast.next.next;
      }
      fast=slow.next;
      slow.next=null;
      Node n3=null;
      while (fast!=null)
      {
          n3=fast.next;
          fast.next=slow;
          slow=fast;
          fast=n3;
      }
      n3=slow;
      fast=head;
      boolean res=true;
      while (slow!=null&&fast!=null)
      {
          if(slow.value!=fast.value)
          {
              res=false;
              break;
          }
          slow=slow.next;
          fast=fast.next;
      }
      slow=n3.next;
      n3.next=null;
      while (slow!=null)
      {
              fast=slow.next;
              slow.next=n3;
              n3=slow;
              slow=fast;
      }
        return  res;
    }
}
