package recursion;

import java.util.Stack;
//不用额外空间如何让栈逆序存放
public class ReverseStackUsingRecursive {
//     每次从栈中取出最后一个元素,最后将i再放回栈中即逆序
    public static void reverse(Stack<Integer>stack)
    {
        if(stack.empty())
        {
            return;
        }
        int i=getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }

    private static int getAndRemoveLastElement(Stack<Integer> stack) {
        int res=stack.pop();
        if(stack.empty())
        {
            return  res;
        }
        int k=getAndRemoveLastElement(stack);
        stack.push(res);
        return  k;
    }
}
