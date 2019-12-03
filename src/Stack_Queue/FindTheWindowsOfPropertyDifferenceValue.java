package Stack_Queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
//找到数组所有窗口中最大值和最小值差值小于给定数字的窗口
public class FindTheWindowsOfPropertyDifferenceValue {
    public static void main(String[] args) {
        findthewindow(new int[]{1,2,3,4,5},2);
    }
    public  static List<Integer[]>findthewindow(int arr[],int num)
    {
        List<Integer[]>res=new ArrayList<>();
        LinkedList<Integer>max_queue=new LinkedList<>();
        LinkedList<Integer>min_queue=new LinkedList<>();
        int left=0;
        int right=0;
        while (left<arr.length)
        {
            while (right<arr.length)
            {
                while (!max_queue.isEmpty()&&arr[max_queue.peekFirst()]<=arr[right])
                {
                    max_queue.pollLast();
                }
                max_queue.addLast(right);
                while (!min_queue.isEmpty()&&arr[min_queue.peekFirst()]>=arr[right])
                {
                    min_queue.pollLast();
                }
                min_queue.addLast(right);
                while (arr[max_queue.peekFirst()]-arr[min_queue.peekFirst()]>num)
                {
                    break;
                }
                right++;

            }
            handlewith(left,right-1,res);
            if(max_queue.peekFirst()==left)
            {
                max_queue.pollFirst();
            }
            if(min_queue.peekFirst()==left)
            {
                min_queue.pollFirst();
            }
            left++;
        }


        return  res;
    }

    private static void handlewith(int left, int right,List<Integer[]>res) {
        int help=left;
        while (help<=right)
        {
            res.add(new Integer[]{left,help});
            System.out.println(left+","+help);
            help++;
        }
    }
}
