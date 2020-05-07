package leetcode;

/**
 * @program: code
 * @description: LeetCode1111
 * @author: Mr.Wang
 * @create: 2020-04-24 11:53
 **/

public class MaximumNestingDepthOfTwoValidParenthesesStrings {
        /**
        * @Description: 将原数组的奇数深度括号都给B,偶数深度括号给A,这样可以保证将高深度括号分别分给AB
        * @Param:
        * @return:
        * @Author: Mr.Wang
        * @Date: 2020/4/24
        */
    public int[] maxDepthAfterSplit(String seq) {
       int depth=0;
       int res[]=new int[seq.length()];
       for(int i=0;i<seq.length();i++)
       {
           if(seq.charAt(i)=='(')
           {
               depth++;
               if(depth%2==0)
               {
                   res[i]=0;
               }
               else {
                   res[i]=1;
               }

           }
           else
           {

               if(depth%2==0)
               {
                   res[i]=0;
               }
               else {
                   res[i]=1;
               }
               depth--;
           }
       }
        return  res;
    }
}
