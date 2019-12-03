package arr;

import java.util.HashSet;
import java.util.Set;
//给定二维数组,每行代表一个矩阵,索引0,1表示左下角,索引2,3表示右上角,判断所有数组是否能组成一个矩形并且没有重合
public class Perfect_Rectangle {
//    没有重合通过每次加入矩形的面积是否等于最终形成的最小角的点和右上角的点组成的矩形面积判断
//    每循环到一个矩形判断组成的大矩形的可能的右上角的点和左下角的点的位置
//    并且维持一个set,每次加入小矩形的四个拐角点,
//    一旦发现set中有这个点则将其删除否则加入,原理是最终map一定只包括大矩形的4个拐角点

    public static boolean isPrefectRectangle(int Rectangle[][])
    {
        int x1=Integer.MAX_VALUE;
        int y1=Integer.MAX_VALUE;
        int x2=Integer.MIN_VALUE;
        int y2=Integer.MIN_VALUE;
        Set<String> set=new HashSet<>();
        int scale=0;
        for(int[]rect:Rectangle)
        {
            x1=Math.min(x1,rect[0]);
            y1=Math.min(y1,rect[1]);
            x2=Math.max(x2,rect[2]);
            y2=Math.max(y2,rect[3]);
            scale+=(y2-y1)*(x2-x1);
            String s1=x1+"_"+y1;
            String s2=x1+"_"+y2;
            String s3=x2+"_"+y1;
            String s4=x2+"_"+y2;
            if(!set.add(s1))
            {
                set.remove(s1);
            }
            if(!set.add(s2))
            {
                set.remove(s2);
            }
            if(!set.add(s3))
            {
                set.remove(s3);
            }
            if(!set.add(s4))
            {
                set.remove(s4);
            }

        }
        if(!set.contains(x1+"_"+y1)||!set.contains(x1+"_"+y2)||
                !set.contains(x2+"_"+y1)||!set.contains(x2+"_"+y2)||set.size()!=4)
        {
            return false;
        }
        return scale==(y2-y1)*(x2-x1);
    }
}
