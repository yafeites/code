package String;
//将string中的前n个数逆序放在最后
public class move_n_pos {
    public static void main(String[] args) {
        move("12345",2);
    }
    public  static  void move(String s,int n)
    {
//        System.out.println(s.length());
        String res;
        res=reverse(s,0,n-1);
//        for(int i=0;i<res.length();i++)
//        {
//            System.out.println(res.charAt(i));
//        }
        res=reverse(res,n,s.length()-1);
        res=reverse(res,0,s.length()-1);

        System.out.println(res);
    }

    private static String reverse(String s, int i, int j) {
         char[]chs=s.toCharArray();

        char temp;
        while (i<j)
        {
            temp=chs[i];
            chs[i]=chs[j];
            chs[j]=temp;
            i++;
            j--;
        }
//        System.out.println(chs);
        return  new String (chs).toString();
    }
}
