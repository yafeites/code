package dynamic;

public class MinPath {
    public static int minPath(int[][]matrix)
    {
        return  process(matrix,0,0);

    }

    private static int process(int[][] matrix, int i, int j) {
        if(i==matrix.length-1&&j==matrix[0].length-1)
        {
            return matrix[i][j];
        }
        if(i==matrix.length-1)
        {
            return matrix[i][j]+process(matrix,i,j+1);
        }
        if(j==matrix[0].length-1)
        {
            return  matrix[i][j]+process(matrix,i+1,j);
        }
        else
        {
            return matrix[i][j]+Math.max(process(matrix,i+1,j),process(matrix,i,j+1));
        }
    }
    public static  int minPath2(int matrix[][])
    {
        int height=matrix.length;
        int length=matrix[0].length;
        int arr[][]=new int[height][length];

        for(int i=height-1;i>0;i--)
        {
            for(int j=length-1;j>0;j--)
            {
                if(i==height-1&&j==length-1)
                {
                    arr[i][j]=matrix[height-1][length-1];
                }
                else if(i!=height-1&&j!=length-1)
                {
                    arr[i][j]=matrix[i][j]+Math.max(arr[i+1][j],arr[i][j+1]);
                }
                else if(i==height-1)
                {
                    arr[i][j]=matrix[i][j]+arr[i][j+1];
                }
                else

                {
                    arr[i][j]=matrix[i][j]+arr[i+1][j];
                }

            }
        }
        return  arr[0][0];

    }
}
