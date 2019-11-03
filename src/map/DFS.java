package map;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DFS {
//    维持一个栈和一个set,每次从stack中取一个node,如果该node的所有next结点只要有一个没加入set则加入并且将原node和next加入。
    public  static void dfs(Node node)
        {
            Stack<Node> stack=new Stack<>();
            HashSet<Node>set=new HashSet<>();
            stack.add(node);
            set.add(node);
            System.out.println(node.value);
            while (!stack.empty())
            {
                Node cur=stack.pop();
                for(Node next:cur.nexts)
                {
                    if(!set.contains(next))
                    {
                        stack.push(cur);
                        stack.push(next);
                        set.add(next);
                        System.out.println(next.value);
                        break;
                    }
                }
            }
        }
}
