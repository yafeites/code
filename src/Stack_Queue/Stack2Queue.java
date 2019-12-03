package Stack_Queue;

import java.util.Stack;

public class Stack2Queue {
    Stack<Integer>push;
    Stack<Integer>pop;

    public Stack2Queue() {
        push=new Stack<>();
        pop=new Stack<>();
    }
    public void add(int i)
    {
        push.push(i);
    }
    public void peek()
    {
        pop.peek();
    }
    public int pop()
    {
        if(pop.empty())
        {
            if(push.empty())
            {
                throw new RuntimeException("栈为空");
            }
            while (!push.empty())
            {
                int var=push.pop();
                pop.push(var);
            }
        }
        return pop.pop();
    }

}
