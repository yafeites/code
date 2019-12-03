package String;

public class Max_Length_palindrome_Substr {
    public static void main(String[] args) {
        System.out.println(realfuc("aaccaaaaa"));
    }
    public static int  realfuc(String s1)
    {

        s1=draw(s1);
        System.out.println(s1);
        return  maxLengthPalindromeSubstr(s1)/2;
    }
//     首先将输入的字串进行处理,处理的好处是不需要判断是奇数回文或者偶数回文,直接将结果除2即可
    private static String draw(String s1) {
        char[]chs=s1.toCharArray();
        s1="";
        for(int i=0;i<chs.length;i++)
        {
           s1=s1+"#"+chs[i];
        }
        s1=s1+"#";
      return  s1;
    }
//    维持一个回文子串能达到的最右距离rmaxlength和此串的中心位置center
//     当遍历到i的时候,判断当前i是否在rmaxlength内
//       如果不在需要重新计算,如果在的话有三种情况
//       1.相对于center的对称点的回文长度能超过最左边界则i的最长回文子串为(rmaxlength-i)*2+1
//       2. 相对于center的对称点的回文长度不能超过最左边界则i的最长回文子串为arr[2*center-i]
//       3.相对于center的对称点的回文长度等于最左边界则i的最长回文子串可以从最右边界来进行判断
    public static int maxLengthPalindromeSubstr(String s1)
    {
        int [] arr=new int[s1.length()];
        int max_length=1;
        int maxrightscale=-1;
        int center=-1;
        char[] chs=s1.toCharArray();
        for(int i=0;i<chs.length;i++)
        {
            if(i>maxrightscale)
               {
                   int left=i;
                   int right=i;
                   while (left>=0&&right<chs.length&&chs[left]==chs[right])
                   {
                       left--;
                       right++;
                   }
                   arr[i]=right-left-1;
               }
            else
            {
                if(arr[2*center-i]/2<maxrightscale-center)
                {
                    arr[i]=arr[2*center-i];
                }
                else if(arr[2*center-i]/2>maxrightscale-center)
                {
                    arr[i]=2*(maxrightscale-i)+1;

                }
                else
                {
                    int left=i-(maxrightscale-i);
                    int right=maxrightscale;
                    while (left>=0&&right<chs.length&&chs[left]==chs[right])
                    {
                        left--;
                        right++;
                    }
                    arr[i]=right-left-1;
                    if(arr[i]/2+i>maxrightscale)
                    {
                        center=i;
                        maxrightscale=(arr[i]-1)/2+i;
                    }
                }
            }
            max_length= arr[i]>max_length? arr[i]:max_length;
        }
     return max_length;

    }
}
