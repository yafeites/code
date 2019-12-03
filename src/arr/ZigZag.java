package arr;
//按之字形遍历数组元素
public class ZigZag {
    //维持2个point初始都指向matrix[0][0],结点1先右走再往下走.二结点先往下走再又走
//    再维持一个boolean量fromup每次循环取反,使得从1结点向2结点遍历，下次从二结点向一节点遍历
    public static  void printMatrixZigZag(int[][] matrix)
    {
        int row1=0;
        int col1=0;
        int row2=0;
        int col2=0;
        int endR=matrix.length-1;
        int endC=matrix[0].length-1;
        boolean fromUp=false;
        while (row1!=endR+1)
        {
            printLevel(matrix,row1,col1,row2,col2,fromUp);
            row1=col1==endC? row1+1:row1;
            col1=col1==endC? col1:col1+1;
            row2=row2==endR? row2:row2+1;
            col2=row2==endC? col2+1:col2;
            fromUp=!fromUp;
        }
        System.out.println();
    }

    private static void printLevel(int[][] matrix, int row1, int col1, int row2, int col2, boolean fromUp) {
        if(fromUp)
        {
            while (row1!=row2)
            {
                System.out.println(matrix[row1++][col1--]);
            }
        }
        else
        {
            while (row1!=row2)
            {
                System.out.println(matrix[row2--][col2++]);
            }
        }
    }
}
