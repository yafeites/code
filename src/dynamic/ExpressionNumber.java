package dynamic;

public class ExpressionNumber
{
    public static void main(String[] args) {
        String str="1&0&1";
        System.out.println(expressionNumber(str,false));
    }
    public  static   int expressionNumber(String expression,boolean desired)
    {
        char[]chs=expression.toCharArray();
        if (expression.length() == 0 || expression == null) {
            return  0;

        }
        if(!isVaild(expression))
        {
            return 0;

        }
        int t[][]=new int[expression.length()][expression.length()];
        int f[][]=new int[expression.length()][expression.length()];
//        动态规划的矩阵是一个上三角矩阵,先将所有对角点的值填好,
//        如果要得到[0,expression.length()]的值我们需要沿行方向左边所有偶数点
//        和沿列方向下面所有偶数点都能得到,所以遍历方式和一般情况不太一样
//        i表示按列遍历
      for(int  i=0;i<expression.length();i+=2)
      {
          t[i][i]=chs[i]=='1'? 1:0;
          f[i][i]=chs[i]=='0'? 1:0;
//          j表示行坐标,并且一定比i小
          for(int j=i-2;j>=0;j-=2)
          {
//              k小于i,大于j,表示j到i需要遍历中间点
              for(int k=j;k<i;k+=2)
              {
                  if(chs[k+1]=='&')
                  {
                      t[j][i]+=t[j][k]*t[k+2][i];
                      f[j][i]+=(t[j][k]+f[j][k])*f[k+2][i]+f[j][k]*t[k+2][i];
                  }
                  else  if(chs[k+1]=='|')
                  {
                      t[j][i]+=(t[j][k]+f[j][k])*t[k+2][i]+t[j][k]*f[k+2][i];
                      f[j][i]+=f[j][k]*f[k+2][i];
                  }
                  else
                  {
                      t[j][i]+=t[j][k]*f[k+2][i]+f[j][k]*t[k+2][i];
                      f[j][i]+=f[j][k]*f[k+2][i]+t[j][k]*t[k+2][i];
                  }
              }
          }
      }
        return desired? t[0][expression.length()-1]:f[0][expression.length()-1];
    }

    private static boolean isVaild(String expression) {
        char[]chs=expression.toCharArray();
        for(int i=0;i<chs.length;i++)
        {
            if(i%2==0)
            {
                if(chs[i]!='0'&&chs[i]!='1')
                {
                    return  false;
                }
            }
            else
            {
                if(chs[i]!='|'&&chs[i]!='&'&&chs[i]!='^')
                {
                    return false;
                }
            }
        }
        return  true;
    }
}
