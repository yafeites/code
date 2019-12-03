package problems;
//用位解决4则运算
public class AddMinusMultiDivideByBit {
    public static void main(String[] args) {
        System.out.println(divide(-5,-5));
//        System.out.println(add(-1,1));

    }
    public  static int add(int a ,int b)
    {

      int res=a;
//      一旦b为0,则表示没有进位的可能,则计算结束
       while (b!=0)
       {
//           将非进位的结果保留给res
            res=a^b;
//           将进位符保留给b
           b=(a&b)<<1;
           a=res;
       }
       return res;
    }
    public  static  int minus(int a,int b)
    {
        return add(a,neg(b));
    }

    private static int neg(int b) {
//        -b就等于b取反加1
        return add(~b,1);
    }
    public  static int  multi(int a,int b)
    {
        int res=0;
        while (b!=0)
        {
//            如果b的最后一位为1,则让res加上a的值
            if((b&1)==1)
            {
                res=add(res,a);
            }
//            每次计算结束循环到b的下一位进行判断
            a=a<<1;
            b=b>>1;
        }
        return res;
    }
    private  static  boolean isNeg(int a)
    {
        return a<0;
    }
    public  static  int divide(int a,int b)
    {
          int x= isNeg(a)? neg(a):a;
          int y= isNeg(b)? neg(b):b;
          int res=0;
//          a/b的结果转换成二进制数11101表示b×(2^5+2^4+2^3+2^1)等于a所以只要我们找到32位数字里面从大到小位×b小于a的位即可
//        一旦找到一位则将a相应的减少b的倍数
          for(int i=31;i>=0;i=minus(i,1))
          {
//              这里一定要将x左移而不是y右移,虽然原理是一样的,但是由于int是有符号整数,
//              所以在y右移的时候可能将符号位制1,反而出现问题
              if((x>>i)>=y)
              {
                 res|=(1<<i);
                  x=minus(x,y<<i);
              }
          }
          return isNeg(a)^isNeg(b)? neg(res):res;

    }

}
