package leetcode;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: code
 * @description: LeetCode8
 * @author: Mr.Wang
 * @create: 2020-04-24 12:26
 **/

public class atoi {
    public static void main(String[] args) {
        atoi atoi=new atoi();
        atoi.myAtoi1("4193 word");
    }
    public int myAtoi(String str) {
        int i=0;
        while (i<str.length()&&str.charAt(i)==' ')
        {
            i++;
        }
        if(i==str.length())
        {
            return 0;
        }
        boolean flag=false;
        if(str.charAt(i)=='+')
        {
            i++;
        }
        else  if (str.charAt(i)=='-'){
            i++;
            flag=true;
        }
        int res=0;
        while (i<str.length())
        {
            int next=0;
            if(str.charAt(i)>'9'&&str.charAt(i)<'0'||str.charAt(i)==' ')
            {
                break;
            }
            next=str.charAt(i)-'0';
            if(!flag&&(res>Integer.MAX_VALUE/10||res==Integer.MAX_VALUE/10&&next>Integer.MAX_VALUE%10))
            {
                return Integer.MAX_VALUE;
            }
            if(flag&&(-res<Integer.MIN_VALUE/10||-res==Integer.MIN_VALUE/10&&next>Integer.MIN_VALUE%10))
            {
                return  Integer.MIN_VALUE;
            }
            res =10*res+next;
            i++;
        }
        return flag?-res:res;
    }
    class Automaton {
        final String START = "start";
        final String SIGNED = "signed";
        final String IN_NUM = "in_number";
        final String END = "end";
        String state = START;
        Map<String, String[]> map;
        public int sign = 1;
        public long ans = 0;

        public Automaton() {
            map = new HashMap<>();
            map.put(START, new String[]{START, SIGNED, IN_NUM, END});
            map.put(SIGNED, new String[]{END, END, IN_NUM, END});
            map.put(IN_NUM, new String[]{END, END, IN_NUM, END});
            map.put(END, new String[]{END, END, END, END});
        }

        public int get_col(char c) {
            if (c == ' ') return 0;
            if (c == '+' || c == '-') return 1;
            if (c >= '0' && c <= '9') return 2;
            return 3;
        }

        public void get(char c) {
            state = map.get(state)[get_col(c)];
            if (state.equals(IN_NUM)) {
                ans = ans * 10 + c - '0';
                if (sign == 1) {
                    ans = Math.min(ans, Integer.MAX_VALUE);
                } else {
                    // -(long)Integer.MIN_VALUE，这个操作有点东西，不然越界
                    ans = Math.min(ans, -(long)Integer.MIN_VALUE);
                }
            } else if (state.equals(SIGNED))
                sign = c == '+' ? 1 : -1;
        }
    }
        /** 
        * @Description: 有限状态机,由起始,标志位,数字,不确定代码位四种状态所组成,每一个字符可能进行状态变换,但是对于此题需要用long来表示返回值否则会越界
        * @Param:
        * @return:
        * @Author: Mr.Wang 
        * @Date: 2020/4/24 
        */ 
    public int myAtoi1(String str) {
        Automaton automaton = new Automaton();
        char[] c = str.toCharArray();
        for (char ch : c) {
            automaton.get(ch);
        }
        return automaton.sign * ((int) automaton.ans);
    }
}
