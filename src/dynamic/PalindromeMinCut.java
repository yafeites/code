package dynamic;
//判断string需要最少几刀切成全是回文串
public class PalindromeMinCut {
    public  static  int cut(String s)
    {
        char[]chs=s.toCharArray();
        int help[]=new int[s.length()+1];
         boolean p[][]=new boolean[s.length()][s.length()];
        for(int i=s.length()-1;i>=0;i--)
        {
            help[i]=Integer.MAX_VALUE;
            for(int j=i;i<s.length();j++)
            {
//              判断目前i到j是否是回文串
                if(chs[i]==chs[j]&&(j-i<2||p[i+1][j-1]))
                {
                    p[i][j]=true;
                    help[i]=Math.min(help[i],help[j]+1);
                }
            }
        }
        return help[0];

    }
}
