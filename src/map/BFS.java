package map;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static  void bfs(Node node)
    {
        if(node==null)
        {
            return;
        }
        Queue<Node> queue=new LinkedList<>();
        HashSet<Node>set=new HashSet<>();
        queue.add(node);
        set.add(node);
        while (!queue.isEmpty())
        {
            Node n=queue.poll();
            System.out.println(n.value);
            for(Node node1:n.nexts)
            {
                if(!set.contains(node1))
                {
                    queue.add(node1);
                    set.add(node1);
                }
            }
        }
    }
}
