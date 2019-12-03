package String;

import java.util.Stack;

public class Vaild_Expression {
    public static  boolean isVaild(String expression)
    {
        char[]chs=expression.toCharArray();
        Stack<Character>stack=new Stack<>();
        for(int i=0;i<chs.length;i++)
        {
            if(chs[i]=='('||chs[i]=='{'||chs[i]=='[')
            {
                stack.add(chs[i]);
            }
            else if(chs[i]==')'||chs[i]=='}'||chs[i]==']')
            {
                char match=chs[i]=='}'?'{':(chs[i]==')'? '(':']');
                if(stack.isEmpty()||stack.peek()!=match)
                {
                    return false;
                }
            }
        }
        return stack.isEmpty();

    }
}
