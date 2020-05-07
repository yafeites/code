package leetcode;

import com.sun.org.apache.regexp.internal.RE;

/**
 * @program: code
 * @description: LeetCode面试16.03 交点
 * @author: Mr.Wang
 * @create: 2020-04-26 18:52
 **/

public class IntersectionLCCI {
    public static void main(String[] args) {
        IntersectionLCCI intersectionLCCI=new IntersectionLCCI();
        intersectionLCCI.intersection(new int[]{1,0},new int[]{1,1},new int[]{-1,0},new int[]{3,2});
    }
    class  Line
    {
        boolean isHorizontal;
        double k;
        double b;
        int startX;
        int endX;
    }
    class ReturnType
    {
        int res;
    }
        /**
        * @Description: 正常写就行,数学题
        * @Param:
        * @return:
        * @Author: Mr.Wang
        * @Date: 2020/4/26
        */
    public double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
           Line lineA=handle(start1,end1);
           Line lineB=handle(start2,end2);
           //如果都为水平线
           if(lineA.isHorizontal&&lineB.isHorizontal)
           {
               if(start1[0]==start2[0])
               {
                   ReturnType returnType=findIntersection(false,start1,end1,start2,end2);
                   if(returnType==null)
                   {
                       return new double[]{};
                   }
                   return  new double[]{start1[0],returnType.res};
               }
               return  new double[]{};
           }
           else if(lineA.isHorizontal)
           {
               if(start1[0]>=Math.min(start2[0],end2[0])&&start1[0]<=Math.max(start2[0],end2[0]))
               {
                   double resY=start1[0]*lineB.k+lineB.b;
                   if(resY>=Math.min(start1[1],end1[1])&&resY<=Math.max(start1[1],end1[1])
                           &&resY>=Math.min(start2[1],end2[1])&&resY<=Math.max(start2[1],end2[1]))
                   {
                       return new double[]{start1[0],resY};
                   }
               }
               return new double[]{};
           }
           else if(lineB.isHorizontal)
           {
               if(start2[0]>=Math.min(start1[0],end1[0])&&start2[0]<=Math.max(start1[0],end1[0]))
               {
                   double resY=start2[0]*lineA.k+lineA.b;
                   if(resY>=Math.min(start1[1],end1[1])&&resY<=Math.max(start1[1],end1[1])
                           &&resY>=Math.min(start2[1],end2[1])&&resY<=Math.max(start2[1],end2[1]))
                   {
                       return new double[]{start2[0],resY};
                   }
               }
               return new double[]{};

           }
           if(lineA.k==lineB.k)
           {
               if(lineA.b==lineB.b)
               {

                   ReturnType returnType=findIntersection(true,start1,end1,start2,end2);
                   if(returnType==null)
                   {
                        return new double[]{};

                   }
                   double resX=returnType.res;
                   double resY=resX*lineA.k+lineA.b;
                   return new double[]{resX,resY};
               }
                return new double[]{};

           }
           else
           {
               double resX=(lineA.b-lineB.b)/(lineB.k-lineA.k);
               double resY=lineA.k*resX+lineA.b;
               if(resX>=Math.min(start2[0],end2[0])&&resX<=Math.max(start2[0],end2[0])
               &&resX>=Math.min(start1[0],end1[0])&&resX<=Math.max(start1[0],end1[0])&&
               resY>=Math.min(start1[1],end1[1])&&resY<=Math.max(start1[1],end1[1])
                       &&resY>=Math.min(start2[1],end2[1])&&resY<=Math.max(start2[1],end2[1]))
               {
                   return new double[]{resX,resY};
               }
                return new double[]{};
           }
    }
    public  ReturnType findIntersection(boolean XAxis,int[] start1, int[] end1, int[] start2, int[] end2)
    {
        int i=XAxis?0:1;
        if(Math.max(start1[i],end1[i])<Math.min(start2[i],end2[i])||Math.max(start2[i],end2[i])<Math.min(start1[i],end1[i]))
        {
            return null;
        }
        else
        {
            ReturnType returnType=new ReturnType();
           returnType.res= Math.max(Math.min(start1[i],end1[i]),Math.min(start2[i],end2[i]));
           return returnType;
        }

    }

    public  Line handle(int[]start,int end[])
    {
            Line res=new Line();
            if(start[0]==end[0])
            {
                res.isHorizontal=true;
                return res;
            }
            res.k=(double)(start[1]-end[1])/(double) (start[0]-end[0]);
            res.b=start[1]-start[0]*res.k;
            res.startX=start[0]>end[0]?end[0]:start[0];
            res.endX=start[0]+end[0]-res.startX;
            return res;
    }
}
