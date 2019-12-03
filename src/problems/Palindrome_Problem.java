package problems;
//判断是否为回文数
public class Palindrome_Problem {
    public static  boolean isPalindrome(int n)
    {
        if(n<0)
        {
            return  false;
        }
        int help=1;
        while (n/help>10)
        {
            help*=10;
        }
        while (n!=0)
        {
            if(n/help!=n%help)
            {
                return false;
            }
            n=(n%help)/10;
            help/=100;
        }
        return  true;
    }
}
