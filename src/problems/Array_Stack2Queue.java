package problems;

public class Array_Stack2Queue {
//    用数组创造一个栈
    public static class ArrayStack
    {
        Integer []arr;
        Integer index;
        public ArrayStack(int initSize)
        {
            if(initSize<0)
            {
                throw new IllegalArgumentException("the init size is less than 0");
            }
            arr=new Integer[initSize];
            index=0;
        }
        public Integer peek()
        {
            if(index==0)
            {
                return  null;
            }
            return  arr[index-1];
        }
        public void push(int obj)
        {
            if(index==arr.length)
            {
                throw new ArrayIndexOutOfBoundsException("the stack is full");
            }
            arr[index++]=obj;
        }
        public int pop()
        {
            if(index==0)
            {
                throw new ArrayIndexOutOfBoundsException("the stack is empty");

            }
            return  arr[--index];
        }
    }
//    用数组创造一个队列
    public static  class ArrayQueue
    {
        private Integer arr[];
        private int size;
        private Integer start;
        private Integer end;

        public ArrayQueue(int initSize) {
            if(initSize<0)
            {
                throw new IllegalArgumentException("the init size is less than 0");
            }
            arr=new Integer[initSize];
            size=0;
            start=0;
            end=0;
        }
        public Integer peek()
        {
            if(size==0)
            {
                return null;
            }
            return  arr[start];
        }
        public void push(int obj)
        {
            if(size==arr.length)
            {
                throw new ArrayIndexOutOfBoundsException("the queue is full");
            }
            size++;
            arr[end]=obj;
            end=nextIndex(arr.length,end);
        }

        private Integer nextIndex(int length, Integer end) {
            return end==length-1? 0:end+1;
        }
        private  Integer poll()
        {
            if(size==0)
            {
                throw new ArrayIndexOutOfBoundsException("the queue is empty");
            }
            size--;
            int tmp=start;
            start=nextIndex(arr.length,start);
            return  arr[tmp];
        }
    }

}
