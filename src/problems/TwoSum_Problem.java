package problems;

import java.util.Arrays;

public class TwoSum_Problem {
    public  static void threesum(int num[],int target)
    {
        Arrays.sort(num);
        for(int i=0;i<num.length-2;i++)
        {
            if(i==0||num[i]!=num[i-1])
            {
                int left=i+1;
                int right=num.length-1;
                while (left!=right)
                {
                    if(num[left]+num[right]==target&&(left==i+1||num[left]!=num[left-1]))
                    {
                        System.out.println(i+"+"+left+"+"+right);
                        left++;
                    }
                    else if(num[left]+num[right]<target)
                    {
                        left++;
                    }
                    else {
                        right--;
                    }
                }
            }
        }
    }
    public  static  void twosumunqiue(int num[],int target)
    {
        int i=0;int j=num.length-1;
        Arrays.sort(num);
        while (i<j)
        {
            if(num[i]+num[j]==target&&(i==0||num[i]!=num[i-1]))
            {
                System.out.println(i+"+"+j);
                i++;
            }
            else if(num[i]+num[j]<target)
            {
                i++;
            }
            else {
                j--;
            }
        }
    }
    public  static  int [] twosum(int num[],int target)
    {
        int []indices=new int[num.length];
        for(int i=0;i<num.length;i++)
        {
            indices[i]=i;
        }
        if(num.length>2)
        {
            sort(num,indices);
        }
        int i=0;int j=num.length-1;
        while (i<j)
        {
            if(num[i]+num[j]==target)
            {
                return new int[]{indices[i],indices[j]};
            }
            else if(num[i]+num[j]<target)
            {
                i++;
            }
            else {
                j++;
            }
        }
        return  new int[]{-1,-1};
    }

    private static void sort(int[] num,int []indcies) {
        for(int i=1;i<num.length;i++)
        {
            for(int j=i;j>0&&num[j]<num[j-1];j--)
            {
                swap(num,indcies,j-1,j);
            }
        }
    }

    public  static void  swap(int []nums,int[]indices,int i,int j)
    {
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
        tmp=indices[i];
        indices[i]=indices[j];
        indices[j]=tmp;
    }
}
