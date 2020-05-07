package dynamic;
//将string分成2个非空部分,一直这样分下去直到没有可分为止,以二叉树的形式存储这样结构,
//如果这个时候任意调换子树形成的原始串即为string的搅乱串,给定两个字符串,判断是否互为搅乱串
public class TroubleString {
    public static  boolean isTroubleString(String s1,String s2)
    {
        char[] s1_chs=s1.toCharArray();
        char[] s2_chs=s2.toCharArray();
        if(s1.length()!=s2.length())
        {
            return false;
        }
        boolean help[][][]=new boolean[s1.length()+1][s1.length()][s1.length()];
        for(int i=0;i<s1.length();i++)
        {
            for(int j=0;j<s1.length();j++)
            {
                help[1][i][j]=s1_chs[i]==s2_chs[j];
            }
        }
        for(int i=2;i<s1.length()+1;i++)
        {
            for(int j=0;j<=s1.length()-i;j++)
            {
                for(int k=0;k<=s1.length()-i;k++)
                {
                    for(int size=1;size<i;size++)

                    {
                        if((help[size][j][k]&&help[i-size][j+size-1][k+size-1])
                                ||(help[size][j][k+i-size-1]&&help[i-size][j+i-size-1][k]))
                        {
                            help[i][j][k]=true;
                            break;
                        }
                    }

                }
            }
        }
        return help[s1.length()][0][0];

    }

}
