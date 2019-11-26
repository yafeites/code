package problems;

public class UglyNumber {
    public  static boolean  uglynumber1(int n)
    {
        while (n%3==0)
        {
            n/=3;
        }
        while (n%2==0)
        {
            n/=2;
        }
        while (n%5==0)
        {
            n/=5;
        }
        return n==1? true:false;
    }
//    求第n个丑数
    public  static  int uglynumber2(int n)
    {
        int [] help=new int[n];
        help[0]=1;
        int i2=0;
        int i3=0;
        int i5=0;
        int index=1;
        while (index<n){
            help[index]=Math.min(help[i2],Math.min(help[i3],help[i5]));
            if(help[index]==help[i2]*2)
            {
                i2++;
            }
            if(help[index]==help[i3]*3)
            {
                i3++;
            }
            if(help[index]==help[i5]*5)
            {
                i5++;
            }
            index++;
        }
        return help[n-1];

    }

}
