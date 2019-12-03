package recursion;

public class MaxDamage {
    public  static  int  maxdamage(int []arr,int sum)
    {
        int max;
        int matrix[][]=new int[arr.length][sum+1];
        for(int i=matrix.length-1;i>=0;i--)
        {
            matrix[i][sum]=1;
        }
        for(int i=matrix.length-1;i>=0;i--)
        {
            for(int j=matrix[0].length-1;j>=0;j--)
            {
                if(i!=matrix.length-1)
                {
                    matrix[i][j]=matrix[i+1][j];
                }
                if(j+arr[i]<=sum)
                {
                    matrix[i][j]=Math.max(matrix[i][j],arr[i]*matrix[i+1][j+arr[i]]);
                }
            }
        }
        return matrix[0][0];
    }
}
