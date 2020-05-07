package leetcode;

import java.rmi.UnexpectedException;
import java.util.List;
import java.util.Stack;

/**
 * @program: code
 * @description: LeetCode445
 * @author: Mr.Wang
 * @create: 2020-04-14 19:34
 **/
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class TwoSumII {
    public static void main(String[] args) {
        ListNode l1=new ListNode(7);
        l1.next= new ListNode(2);
        l1.next.next= new ListNode(4);
        l1.next.next.next=new ListNode(3);
        ListNode l2=new ListNode(5);
        l2.next=new ListNode(6);
        l2.next.next=new ListNode(4);
        TwoSumII twoSumII=new TwoSumII();
        twoSumII.addTwoNumbers(l1,l2);
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer>stack1=new Stack<>();
        Stack<Integer>stack2=new Stack<>();
        while (l1!=null)
        {
            stack1.push(l1.val);
            l1=l1.next;
        }
        while (l2!=null)
        {
            stack2.push(l2.val);
            l2=l2.next;
        }

        ListNode res=null;
        int surplus=0;
        while (!stack1.isEmpty()||!stack2.isEmpty()||surplus==0)
        {
            int a=stack1.isEmpty()?0:stack1.pop();
            int b=stack2.isEmpty()?0:stack2.pop();
            int sum=a+b+surplus;
            surplus=sum/10;
            ListNode node=new ListNode(sum%10);
            node.next=res;
            res=node;
        }
        return res;


    }
}
