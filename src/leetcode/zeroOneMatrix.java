package leetcode;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.MatchGenerator;

/**
 * @program: code
 * @description: LeetCode542
 * @author: Mr.Wang
 * @create: 2020-04-16 11:57
 **/

public class zeroOneMatrix {
            /** 
            * @Description: 动态规划，任何1找到0肯定是从上下左右任何一个位置开始的，先顺序遍历再逆序遍历即可找到可能的最小的距离 
            * @Param:
            * @return:  
            * @Author: Mr.Wang 
            * @Date: 2020/4/17
            */ 
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix==null||matrix.length==0)
        {
            return null;
        }
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                if(matrix[i][j]==1)
                {
                    matrix[i][j]=10000;
                }
            }
        }
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                if(i>0)
                {
                    matrix[i][j]= Math.min(matrix[i][j],matrix[i-1][j]+1);
                }
                if(j>0)
                {
                    matrix[i][j]= Math.min(matrix[i][j],matrix[i][j-1]+1);
            }
            }
        }
        for(int i=matrix.length-1;i>=0;i--)
        {
            for(int j=matrix[0].length-1;j>=0;j--)
            {
                if(i<matrix.length-1)
                {
                    matrix[i][j]= Math.min(matrix[i][j],matrix[i+1][j]+1);
                }
                if(j<matrix[0].length-1)
                {
                    matrix[i][j]= Math.min(matrix[i][j],matrix[i][j+1]+1);
                }
            }
        }
        return matrix;
    }
}
