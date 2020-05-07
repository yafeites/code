package Stack_Queue;

import java.util.Map;
import java.util.Stack;

public class MaxSizeInArray {
    public static void main(String[] args) {
        System.out.println(maxSizeInArray(new int[]{5,4,6,3,6,5,4}));
    }
    public  static  int maxSizeInArray(int []num)
    {
        Stack<Integer>stack=new Stack<>();
        int help[]=new int[num.length];
        for(int i=0;i<num.length;i++)
        {

            while (!stack.isEmpty()&&(num[stack.peek()]>num[i]))
            {
                int temp=stack.pop();
                help[temp]=i;
                if(!stack.isEmpty())
                {
                    // 如果栈中还有数则左边比它小的数为栈中下一个数,否则不存在
                    help[temp]=help[temp]-stack.peek()-1;
                }
            }
            stack.add(i);
        }
        while ( !stack.isEmpty())
        {
            int temp=stack.pop();
            help[temp]=num.length;
            if(!stack.isEmpty())
            {
                // 如果栈中还有数则左边比它小的数为栈中下一个数,否则不存在
                help[temp]=help[temp]-stack.peek()-1;
            }
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<num.length;i++)
        {
            max= Math.max(max,num[i]*help[i]);
        }

        return max;

    }
}
