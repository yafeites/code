package recursion;
//每个骑士和每条龙都有其武力值,一旦骑士的武力值大于龙的武力值就可以杀掉他
//但需要付出武力值同等的金币,如果可以使骑士合力砍龙,使得所付金币最少需要的武力值是多少
public class Kill_Dragon {
    public  static  int Knight_vs_Dragon(int []Knight,int[]Dragon)
    {
        int sum=0;
        int max=0;
        for(int i=0;i<Dragon.length;i++)
        {
            max=Math.max(Dragon[i],max);
        }
//        压缩数组,只需要一行即可
        boolean help[]=new boolean[max+1];
        for(int i=0;i<Knight.length;i++)
        {
            for(int j=0;j<help.length;j++)
            {
                if(j-Knight[i]>=0)
                {
                    help[j]|=help[j-Knight[i]];
                }
            }
        }
//        对于每一条龙,寻找比其大的最小的合力值
        for(int aim=0;aim<Dragon.length;aim++)
        {
            int temp=aim;
            while (!help[temp])
            {
                temp++;
            }
            sum+=temp;
        }
        return sum;
    }
}
