package Stack_Queue;

import java.util.Stack;
//栈结构构造getmin方法返回栈中目前最小值
public class MyStack {
    private Stack<Integer>stack;
    private  Stack<Integer>min_stack;
    public  MyStack()
    {
        this.stack=new Stack<Integer>();
        this.min_stack=new Stack<Integer>();
    }
    public void push(int num)
    {
        if(stack.empty())
        {
            min_stack.push(num);
        }
        else if(num<getmin())
            {
                min_stack.push(num);
            }
        else
        {
            int newmin=min_stack.peek();
            min_stack.push(newmin);
        }
    }
    public void pop()
    {
        if(stack.empty())
        {
            throw  new RuntimeException("your stack is empty");
        }
        stack.pop();
        min_stack.pop();
    }

    private int getmin() {
        return min_stack.peek();
    }
}
