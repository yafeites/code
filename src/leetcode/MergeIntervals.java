package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @program: code
 * @description: LeetCode56
 * @author: Mr.Wang
 * @create: 2020-04-17 10:06
 **/

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0]-b[0];
            }
        });
        List<int[]>res=new ArrayList<>();
        for(int i=0;i<intervals.length;i++)
        {
            if(res.isEmpty())
            {
                res.add(intervals[i]);
            }
            else
            {
                int size=res.size();
                int []behind=res.get(size-1);
                if(behind[1]>=intervals[i][0])
                {
                    behind[1]=Math.max(intervals[i][1],behind[1]);
                }
                else
                {
                    res.add(intervals[i]);
                }
            }
        }
        return res.toArray(new int[0][]);
    }

}
