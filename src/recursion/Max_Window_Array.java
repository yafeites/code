package recursion;

import java.util.LinkedList;
import java.util.Queue;
//给定一个数组和窗口n求对应于数组中的每一个窗口的最大值
public class Max_Window_Array {
//    维持一个双向队列遍历数组元素,每次将将新元素放入,并且保证在队列前面的数一定比其大,每次遍历如果队列最前方的值已经不在窗口中则将其移除
    public  static int [] max_win_arr(int arr[],int n) {
        int res[] = new int[arr.length - n + 1];
        LinkedList<Integer> qmax = new LinkedList<Integer>();

        for (int i = 0; i <arr.length;i++)
        {
            while (!qmax.isEmpty()&&arr[qmax.peekLast()]<=arr[i])
            {
                qmax.pollLast();
            }
            qmax.addLast(i);
            if(qmax.peekLast()==i-n)
            {
              qmax.peekFirst();
            }
            if(i>=n-1)
            {
                res[i++]=arr[qmax.peekFirst()];
            }
        }
            return  res;

    }
}
