package map;

public class GraphGenerator {
    public static  Graph createGraph(Integer[][] matrix)
    {
        Graph graph=new Graph();
        for(int i=0;i<matrix.length;i++)
        {
                Integer from=matrix[i][0];
                Integer to=matrix[i][1];
                Integer weight=matrix[i][2];
                if(!graph.nodes.containsKey(from))
                {
                    graph.nodes.put(from,new Node(from));
                }
                if(!graph.nodes.containsKey(to))
                {
                    graph.nodes.put(from,new Node(to));
                }
                Node fromNode=graph.nodes.get(from);
                Node toNode= graph.nodes.get(to);
                Edge newEdge=new Edge(weight,fromNode,toNode);
                graph.edges.add(newEdge);
                fromNode.edges.add(newEdge);
                fromNode.nexts.add(toNode);
                fromNode.out++;
                toNode.in++;


        }
        return  graph;
    }
}
