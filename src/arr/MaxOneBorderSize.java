package arr;
//找寻二维数组中存在的最大正方形
public class MaxOneBorderSize {
    public static void main(String[] args) {
                int test[][]=new int[][]{{0,1,1,1,1},{0,1,0,0,1},{0,1,0,0,1},{0,1,1,1,1},{0,1,0,1,1}};
                System.out.println(maxsize(test));
    }
    public  static int maxsize(int matrix[][])
    {
        int [][]right=createmaxrightlengthmatrix(matrix);
        int [][]down=createmaxdownlengthmatrix(matrix);
        for(int size=matrix.length;size>0;size--)
        {
            if(hasmaxsize(size,right,down))
            {
                return size;
            }

        }
        return 0;

    }

    private static boolean hasmaxsize(int size, int[][] right, int[][] down) {
        for(int i=0;i<right.length-size+1;i++)
        {
            for(int j=0;j<right[0].length-size+1;j++)
            {
                if(right[i][j]>=size&&right[i+size-1][j]>=size&&down[i][j]>=size&&down[i][j+size-1]>=size)
                {
                    return true;
                }
            }
        }
        return false;

    }

    private static int[][] createmaxdownlengthmatrix(int[][] matrix) {
        int [][]res=new int[matrix.length][matrix[0].length];
        for(int i=matrix.length-1;i>=0;i--)
        {
            for(int j=matrix[0].length-1;j>=0;j--)
            {
                if(matrix[i][j]==1)
                {
                    res[i][j]=1;
                    if(i!=matrix.length-1)
                    {
                    res[i][j]+=res[i+1][j];
                    }

                }
            }
        }
        return res;
    }

    private static int[][] createmaxrightlengthmatrix(int[][] matrix) {
        int [][]res=new int[matrix.length][matrix[0].length];
        for(int i=matrix.length-1;i>=0;i--)
        {
            for(int j=matrix[0].length-1;j>=0;j--)
            {
                if(matrix[i][j]==1)
                {
                    res[i][j]=1;
                    if(j!=matrix[0].length-1)
                    {
                        res[i][j]+=res[i][j+1];
                    }

                }
            }
        }
        return res;
    }

}
