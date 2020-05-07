package dynamic;
//背包问题
public class MaxValue {
    public static  int maxvalue(int weight[],int value[],int bag)
    {
        return  process1(weight,value,0,0,bag);

    }
    public  static  int process1(int weight[],int value[],int i,int alreadyweight,int bag)
    {
        if (alreadyweight > bag) {

            return Integer.MIN_VALUE;
        }
        if(i==weight.length)
        {
            return 0;
        }
         return Math.max(value[i]+process1(weight,value,i+1,alreadyweight+weight[i],bag),process1(weight,value,i+1
         ,alreadyweight,bag));

    }
    public static  int maxvalue2(int weight[],int value[],int bag)
    {
        int arr[][]=new int[weight.length][bag+1];
        for (int i=arr.length-1;i>=0;i--)
        {
            for(int j=bag;j>=0;j--)

            {
                arr[i][j]=arr[i+1][j];
                if(weight[j]+j<=bag)
                {
                    arr[i][j]=Math.max(arr[i][j],arr[i+1][j+weight[j]]+value[j]);
                }
            }
        }
        return  arr[0][0];
    }

}

