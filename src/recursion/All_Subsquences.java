package recursion;

public class All_Subsquences {
    public static  void printAllSub(String str)
    {
        char[]chs=str.toCharArray();
        fun(chs,0,"");
    }

    private static void fun(char[] chs, int i, String s) {
        if(i==chs.length)
        {
            System.out.println(s);
            return;
        }

        else
        {
            fun(chs,i+1,s+String.valueOf(chs[i]));
            fun(chs,i+1,s);
        }

    }
}
