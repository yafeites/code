package map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Dijkstra {
    public static HashMap<Node,Integer> dijkstra(Node head)
    {
//        思想:维持一个hashset放已经计算过的点,一个distancemap存放每一个点对应与head结点的最小距离。
//          每次从distancemap中取得一个到head结点距离最小的点node,
//          并且将与其相邻的所有点进行计算是否到head结点的距离有因node被包含后有所改变


        HashMap<Node,Integer> distancemap=new HashMap<>();
        distancemap.put(head,0);
        HashSet<Node>selectedNodes=new HashSet<>();
        Node minNode=getMinDistanceAndUnSelectedNode(distancemap,selectedNodes);
        while (minNode!=null)
        {
            int distance=distancemap.get(minNode);
            for(Edge edge:minNode.edges)
            {
                Node toNode=edge.to;
                if(!distancemap.containsKey(toNode))
                {
                    distancemap.put(toNode,distance+edge.weight);
                }
                else
                {
                    distancemap.put(toNode,Math.min(distance+edge.weight,distancemap.get(toNode)));
                }
            }
            selectedNodes.add(minNode);
            minNode=getMinDistanceAndUnSelectedNode(distancemap,selectedNodes);
        }
        return  distancemap;

    }

    private static Node getMinDistanceAndUnSelectedNode(HashMap<Node, Integer> distancemap, HashSet<Node> selectedNodes) {
        Node minNode =null;
        int minDistance=Integer.MIN_VALUE;
        for(Map.Entry<Node,Integer> entry:distancemap.entrySet())
        {
            Node node=entry.getKey();
            int distance=entry.getValue();
            if(!selectedNodes.contains(node)&&distance<minDistance)
            {
                minNode=node;
                minDistance=distance;
            }
        }
        return minNode;
    }
}
