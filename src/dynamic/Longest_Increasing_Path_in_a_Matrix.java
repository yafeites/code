package dynamic;
//最长递增序列
public class Longest_Increasing_Path_in_a_Matrix {
    public  static  int  process(int [][]arr)
    {
        int[][]help=new int[arr.length][arr[0].length];
        int max=0;
        for(int row=0;row<arr.length;row++)
        {
            for(int col=0;col<arr[0].length;col++)
            {
                max=Math.max(max,maxIncrease(arr,help,row+1,col,arr[row][col])+1);
                max=Math.max(max,maxIncrease(arr,help,row,col+1,arr[row][col])+1);
                max=Math.max(max,maxIncrease(arr,help,row-1,col,arr[row][col])+1);
                max=Math.max(max,maxIncrease(arr,help,row,col-1,arr[row][col])+1);
            }
        }
        return max;
    }

    private static int  maxIncrease(int[][] arr, int[][] help, int row, int col, int i1) {
        if(row<0||row>=arr.length||col<0||col>arr[0].length||i1<arr[row][col])
        {
            return 0;
        }

        if(help[row][col]==0)
        {
            help[row][col]=Math.max(help[row][col],maxIncrease(arr,help,row+1,col,arr[row][col])+1);
            help[row][col]=Math.max(help[row][col],maxIncrease(arr,help,row,col+1,arr[row][col])+1);
            help[row][col]=Math.max(help[row][col],maxIncrease(arr,help,row-1,col,arr[row][col])+1);
            help[row][col]=Math.max(help[row][col],maxIncrease(arr,help,row,col-1,arr[row][col])+1);
        }
        return help[row][col];
    }
}
