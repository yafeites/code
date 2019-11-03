package map;

import java.util.*;
//拓扑排序算法,每次将入度为0的结点加入queue,再将该node的nexts结点的入度都减一
public class TopologySort {
    public static List<Node> sortedTopology(Graph graph)
    {
        HashMap<Node ,Integer> inmap=new HashMap<>();
        Queue<Node> zeroInQueue=new LinkedList<>();
        for(Node node:graph.nodes.values())
        {
            inmap.put(node,node.in);
           if(node.in==0)

           {
               zeroInQueue.add(node);
           }
        }
        List<Node>res=new ArrayList<>();
        while (!zeroInQueue.isEmpty())
        {
            Node n=zeroInQueue.poll();
            res.add(n);
            for(Node next: n.nexts)
            {
                inmap.put(next,inmap.get(next)-1);
                if(inmap.get(next)==0)
                {
                    zeroInQueue.add(next);
                }
            }

        }
        return res;
    }
}
