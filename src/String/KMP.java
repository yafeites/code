package String;

public class KMP {
    public static void main(String[] args) {
        System.out.println(kmp("ssdfgasdbababa","ababa"));
    }
//    维持一个数组为s2的最大前后缀相等数,从s1和s2的开头进行匹配,一旦匹配匹配失败则将s2的匹配位置变为arr[s2.index]再进行匹配
//      一旦arr[s2.index]为-1则s1匹配位置+1;
    public  static  boolean kmp(String s1,String s2)
    {
        int[] arr;
        arr=getarr(s2);
        int i=0;
        int j=0;
        while(i!=s1.length())
        {
            if(s1.charAt(i)==s2.charAt(j))
            {
                i++;
                j++;
            }
            else
            {
                j=arr[j];
                if(j==-1)
                {
                    i++;
                    j=0;
                }

            }
            if(j==s2.length())
            {
                return  true;
            }
        }
        return  false;
    }
//   人为规定 arr[0]=-1 arr[1]=0
    private static int[] getarr(String s2) {
        int []arr=new int[s2.length()];
        char[] chs=s2.toCharArray();
        if(s2.length()!=1)
        {
            arr[0]=-1;
        }
        if(s2.length()!=2)
        {
            arr[1]=0;
        }
        int cnt=0;
        int i=2;
        while (i!=s2.length())
        {
//            当遍历到i的时候,查看chs[i-1]是否和cnt即i-1对应的最长前后缀后面一个位置相等
        if (chs[i-1]==chs[cnt])
        {
            arr[i]=arr[i-1]+1;
             i++;
             cnt++;
        }
//        如果不相等则将cnt付给arr[cnt]递归判断
        else
        {
            cnt=arr[cnt];
        }
//        如果cnt=-1,则cnt已经到达0位置 将arr[i]赋予0
        if(cnt==-1)
        {
            arr[i++]=0;
            cnt=0;
        }
        }
        return arr;
    }
}
