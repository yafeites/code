package recursion;

public class Hanoi {
    public static void main(String[] args) {
        hanoi(3);
    }
    public  static void hanoi(int n)

    {
        if(n>0)
        {
            func(n,"left","right","mid");
        }
    }

    private static void func(int n, String from, String to, String help) {
        if(n==1)
        {
            System.out.println("move"+1+"from"+from+"to"+to);
        }
        else
        {
            func(n-1,from,help,to);
            System.out.println("move"+n+"from"+from+"to"+to);
            func(n-1,help,to,from);
        }
    }
}
