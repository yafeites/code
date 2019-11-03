package recursion;

public class PrintAllPermutations {
    public  static  void printAllPermutations(String str)
    {
        char[]chs=str.toCharArray();
        process1(chs,0);
    }

    private static void process1(char[] chs, int i) {
        if(i==chs.length)
        {
            System.out.println(chs);
        }
        for(int j=i;j<chs.length;j++)
        {
            swap(chs,i,j);
            process1(chs,i+1);
            swap(chs,i,j);
        }
    }

    private static void swap(char[] chs, int i, int j) {
        char temp=chs[i];
        chs[i]=chs[j];
        chs[j]=temp;
    }
}
