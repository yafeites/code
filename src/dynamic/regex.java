package dynamic;

public class regex {
    public static void main(String[] args) {
        System.out.println(ispair(new String("abcc"),new String("ab.*d.*e.*")));
    }
    public  static  boolean ispair(String str,String expression)
    {

        char[]str_chs=str.toCharArray();
        char[]expression_chs=expression.toCharArray();
        boolean[][]help= init(str_chs,expression_chs);
        for(int i=str.length()-1;i>=0;i--)
        {
            for(int j=expression.length()-1;j>=0;j--)
            {

                if(j==expression.length()-1||expression_chs[j+1]!='*')
                {
                    help[i][j]= (str_chs[i]==expression_chs[j]||expression_chs[j]=='.')
                            &&help[i+1][j+1];
                }
                else
                {
                    int si=i;
                    while (si!=str.length()&&(str_chs[si]==expression_chs[j]||expression_chs[j]=='.'))
                    {
                        if(help[si][j+2])
                        {
                            help[i][j]=true;
                            break;
                        }
                        si++;
                    }
//                    如果s和e当前索引不相等或者s到达尾部则可以舍弃掉x*组合
                    if(help[i][j]!=true)
                    {
                        help[i][j]=help[si][j+2];
                    }
                }
            }
        }
        return  help[0][0];
    }

    private static boolean[][] init(char[] str_chs, char[] expression_chs) {
        int str_end=str_chs.length;
        int expression_end=expression_chs.length;
        boolean help[][]=new boolean[str_end+1][expression_end+1];
        help[str_end][expression_end]=true;
        for(int i=expression_end-2;i>=0;i-=2)
        {
            if(expression_chs[i+1]=='*')
            {
                help[str_end-1][i]=true;
            }
            else  break;
        }
        return help;
    }


}
