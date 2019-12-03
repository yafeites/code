package arr;
//从arr[0][0]开始按向右向下向左向上的顺序遍历数组
public class  PrintMatrixSpiralOrder{
    public  static void spiralOrderPrint(int [][]matrix)
    {
//        取左上角和右下角的值划分此次遍历的结点，每次遍历结束后将左上角的值向下移动一点，右下角的值向上移动一些.
        int row1=0;
        int col1=0;
        int row2=matrix.length-1;
        int col2=matrix[0].length-1;
        while(row1<=row2&&col1<=col2)
        {
            printEdge(matrix,row1,col1,row2,col2);
        }
    }

    private static void printEdge(int [][]matrix,int row1, int col1, int row2, int col2) {
        if(row1==row2) {
            for (int i = col1; i <= col2; i++) {
                System.out.println(matrix[row1][i]);
            }
        }

        else if(col1==col2)
        {
              for(int j=row1;j<=row2;j++)
            {
                System.out.println(matrix[j][row1]);
            }
        }
        else
        {
            int CurC=col1;
            int Curr=row1;
            while (CurC!=col2)
            {
                System.out.println(matrix[row1][CurC++]);
            }
            while (Curr!=row2)
            {
                System.out.println(matrix[Curr][row2++]);
            }
            while (CurC!=col2)
            {
                System.out.println(matrix[row2][CurC--]);
            }
            while (Curr!=row1)
            {
                System.out.println(matrix[Curr++][row1]);
            }
        }
    }
}
