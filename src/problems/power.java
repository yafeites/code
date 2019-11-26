package problems;

public class power {
    public static void main(String[] args) {
        System.out.println(power(2,1));
    }
//    将n转换成二进制,每次查看最低位是否为1,为1就乘上目前的x
    public  static  int power(int x,int n)
    {
        int res=1;
        for(int i = n; i != 0; i /= 2){
            if(i % 2 != 0){
                res *= x;
            }
            x *= x;
        }
        return n>0? res:1 /res;
    }
}
