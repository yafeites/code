package map;

import java.util.*;

public class Kruskal {
    public static  class EdgeComparator implements Comparator<Edge>
    {
        @Override
        public  int compare(Edge o1,Edge o2)
        {
            return  o1.weight-o2.weight;
        }
    }
    public static Set<Edge> kruskalMST(Graph graph)
    {
//        每次从边集合中抽取value最小的边,如果此边的两端不在一个union中则此边可以,并将此边的两个node加入一个union
        UnionFind unionFind=new UnionFind();
        unionFind.makeSets((List)graph.nodes.values());
        PriorityQueue<Edge> priorityQueue=new PriorityQueue<>(new EdgeComparator());
        for(Edge edge: graph.edges)
        {
            priorityQueue.add(edge);
        }
        Set<Edge>res=new HashSet<>();
        while (!priorityQueue.isEmpty())
        {
            Edge edge=priorityQueue.poll();
            if(!unionFind.isSameSet(edge.from,edge.to))
            {
                res.add(edge);
                unionFind.union(edge.from,edge.to);
            }
        }
return  res;
    }
}
