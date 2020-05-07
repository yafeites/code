package dynamic;

public class SubMatrixMaxSum {
    public static void main(String[] args) {
        int[][]arr=new int[][]{{1,2,4},{1,-2,3}};
        System.out.println(subMatrixMaxSum(arr));
    }
    public  static  int subMatrixMaxSum(int [][]matrix)
    {
        int max=0;
        for(int i=0;i<matrix.length;i++)
        {
            int []help=new int[matrix[0].length];
            for(int j=i;j<matrix.length;j++)
            {
                int cur=0;
                for(int k=0;k<matrix[0].length;k++)
                {
                     help[k]+=matrix[j][k];
                    cur=(cur+=help[k])>=0?cur:0;
                    max=Math.max(cur,max);
                }
            }
        }
        return  max;
    }


}
