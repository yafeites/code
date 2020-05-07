package Stack_Queue;

import java.util.Stack;
//给定全为0,1的二维数组,找到包含全为1的最大矩阵size
public class MaxMatrixSize {
    public static void main(String[] args) {
      System.out.println(maxMatrixSize(new int[][]{{1,0,1,1},{1,1,1,1},{1,1,1,0}}));
    }
    public  static  int maxMatrixSize(int num[][])
    {
        Stack<Integer> stack=new Stack<>();
        int help[]=new int[num[0].length];
        int max=Integer.MIN_VALUE;
        for(int cnt=0;cnt<num.length;cnt++)
        {
            for(int i=0;i<num[0].length;i++)
            {
//                对二维数组的每一行进行单调栈求最大面积的过程
//                help数组的含义是包括此行所累积的正上方1的个数
                if(cnt>0)
                {
                    num[cnt][i]=(num[cnt-1][i]+num[cnt][i])*num[cnt][i];
                }
                while (!stack.isEmpty()&&(num[cnt][stack.peek()]>num[cnt][i]))
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

            for(int i=0;i<num.length;i++)
            {
                max= Math.max(max,num[cnt][i]*help[i]);
            }
        }
        return max;

    }
}
