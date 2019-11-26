package problems;
//如果1个字符串只能由0,1组合并且每一个0前面必有1个1,则给定字符串长度n,求有多少种情况
public class ZeroLeftOneStringNumber {
//    首先长度为n的字符串首字符必须为1,并且如果第二个字符为1的情况下说明(2-n)必须为合法字符串,
//    如果第二个字符为0,(3-n)必须为合法字符串
    public static  int zeroleftone(int n)
    {
        if(n==1)
        {
            return 1;
        }
        if(n==2)
        {
            return  2;
        }
      int pre=1;
      int cur=2;
      int temp;
//      如果f(n)=f(n-1)+f(n-2)则只需要2个变量和一个temp就可以,如果是n-3,则需要3个变量和2个temp
      for(int i=3;i<=n;i++)
      {
          temp=cur;
          cur=cur+pre;
          pre=cur;
      }
      return  cur;

    }


}
