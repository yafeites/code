package problems;



import java.util.LinkedList;
import java.util.Queue;
//队列形成栈
public class Queue2Stack {
//    构造双队列，每次pop时将queue中的元素放入help中，只留下一个元素返回，再讲help和queue交换引用
    private Queue<Integer>queue;
    private Queue<Integer>help;

    public Queue2Stack() {
        queue =new LinkedList<>();
        help=new LinkedList<>();
    }
    public void push(int num)
    {
        queue.add(num);
    }
    public int peek()
    {
        if(queue.isEmpty())
        {
            throw new RuntimeException("栈为空");
        }
        while (queue.size()!=1)
        {
            help.add(queue.poll());
        }
        int res=queue.poll();
        help.add(res);
        swap();
        return  res;
    }

    private void swap() {
        Queue<Integer>temp=queue;
        queue =help;
        help=temp;
    }

    public int pop()
    {
        if(queue.isEmpty())
        {
            throw new RuntimeException("栈为空");
        }
        while (queue.size()!=1)
        {
            help.add(queue.poll());
        }
        int res=queue.poll();
        swap();
//        help.add(res);
        return  res;
    }

}
