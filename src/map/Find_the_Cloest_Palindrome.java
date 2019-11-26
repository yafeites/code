package map;
//找寻给定离给定数字最近的回文树
public class Find_the_Cloest_Palindrome {
    public  static  String nearestPalindromic(String n)
    {
        Long num=Long.valueOf(n);
        Long raw=rawPalindromic(n);
        Long minnum=raw>num? smallerPalindromic(n):raw;
        Long maxnum=raw>num? raw:biggerPalindromic(n);
        return String.valueOf(num-minnum<maxnum-num? minnum:maxnum);
    }

    private static Long biggerPalindromic(String num) {
        char[]chs=num.toCharArray();
        char[]res=new char[chs.length+1];
        res[0]='0';
        for(int i=0;i<chs.length;i++)
        {
            res[i+1]=chs[i];
        }
        int size=res.length;
        for(int i=(size-1)/2+1;i>0;i++)
        {
            if(++res[i]>'9')
            {
                    res[i]='0';
            }
            else
            {
                break;
            }
        }
        int offest=res[0]=='1' ?1:0;
        size=res.length;
        for(int i=size-1;i>=(size+offest)/2;i--)
        {
                res[i]=res[size-i-offest];
        }
        return Long.valueOf(String.valueOf(res));
    }

    private static Long smallerPalindromic(String num) {
        char[]chs=num.toCharArray();
        int size=chs.length;
        for(int i=size/2;i>=0;i--)
        {
            if(--chs[i]<'0')
            {
                chs[i]=9;
            }
            else
            {
                break;
            }
        }
        if(chs[0]=='0')
        {
            for(int i=1;i<chs.length;i++)
            {
                chs[i]='9';
            }
            return Long.valueOf(String.valueOf(chs));
        }
         for(int i=0;i<size/2;i++)
         {
             chs[size-1-i]=chs[i];
         }
         return  Long.valueOf(String.valueOf(chs));


    }

    private static Long rawPalindromic(String num) {
        char[]chs=num.toCharArray();
        for(int i=0;i<chs.length/2;i++)
        {
            chs[chs.length-1-i]=chs[i];
        }
        return Long.valueOf(String.valueOf(chs));
    }
}
