package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: code
 * @description: LeetCode466
 * @author: Mr.Wang
 * @create: 2020-04-27 15:01
 **/

public class CountTheRepetitions {
    class Pair
    {
        int S1Cnt;
        int S2Cnt;

        public Pair(int s1Cnt, int s2Cnt) {
            S1Cnt = s1Cnt;
            S2Cnt = s2Cnt;
        }
    }
        /**
        * @Description: 对于循环的s1一定存在在一个s1结束后有一个确切的s2的目前索引位置,而一旦有s2长度+1的s1后一定存在一个重复的索引位置,这就是循环节
         * 找到节后对于s1前n个没入节的部分和后面不够一个节的部分另算即可
        * @Param:
        * @return:
        * @Author: Mr.Wang
        * @Date: 2020/4/27
        */
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if(n1==0)
        {
            return  0;
        }
        //目前经历到的s2索引
        int index=0;
//        s1和s2已经经历的次数
        int S1Cnt=0;
        int S2Cnt=0;
        Pair pre;
        Pair end;
        Map<Integer, Pair>map=new HashMap<>();
        while (true)
        {
            for(int i=0;i<s1.length();i++)
            {
                if(s1.charAt(i)==s2.charAt(index))
                {
                    index++;
                    if(index==s2.length())
                    {
                        index=0;
                        S2Cnt++;
                    }
                }
            }
            S1Cnt++;
            if(S1Cnt==n1)
            {
                return S2Cnt/n2;
            }
            if(!map.containsKey(index))
            {
                map.put(index,new Pair(S1Cnt,S2Cnt));
            }
            else {
                pre=map.get(index);
                end=new Pair(S1Cnt,S2Cnt);
                break;
            }
        }
        int S1Loop=end.S1Cnt-pre.S1Cnt;
        int S2Loop=end.S2Cnt-pre.S2Cnt;
        int initCnt=pre.S2Cnt;
        int nowCnt=((n1-pre.S1Cnt)/S1Loop)*S2Loop+initCnt;
        int restS1=(n1-pre.S1Cnt)%S1Loop;
        while (restS1!=0)
        {
            for(int i=0;i<s1.length();i++)
            {
                if(s1.charAt(i)==s2.charAt(index))
                {
                    index++;
                    if(index==s2.length())
                    {
                        index=0;
                        nowCnt++;
                    }
                }
            }
            restS1--;
        }
        return  nowCnt/n2;
    }
}
