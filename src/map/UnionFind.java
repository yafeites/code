package map;

import java.util.HashMap;
import java.util.List;

public class UnionFind {



//        hashmap表示k的父节点是v
        public HashMap<Node,Node>fathermap;
//          如果k表示的Node的是此集合的father节点则v代表集合的size
        public HashMap<Node,Integer> rankmap;
        public UnionFind(){
            fathermap=new HashMap<Node,Node>();
            rankmap=new HashMap<Node,Integer>();
        }
        public void makeSets(List<Node>nodes)
        {
            fathermap.clear();
            rankmap.clear();
            for(Node node:nodes)
            {
                fathermap.put(node,node);
                rankmap.put(node,1);
            }
        }
        public boolean isSameSet(Node node1,Node node2)

        {
            return findFather(node1)==findFather(node2);
        }
        public Node findFather(Node node)
        {
            Node father=fathermap.get(node);
            if (father!=node)
            {
                father=fathermap.get(father);
            }
            fathermap.put(node,father);
            return  father;
        }
        public void union(Node a,Node b)
        {
            if (a == null || b == null) {

                return;
            }
            Node afather=findFather(a);
            Node bfather=findFather(b);
            if(afather!=bfather)
            {
                int asize=rankmap.get(afather);
                int bsize=rankmap.get(bfather);
                if(asize<bsize)
                {
                    fathermap.put(afather,bfather);
                    rankmap.put(afather,asize+bsize);
                }
                else
                {
                    fathermap.put(bfather,afather);
                    rankmap.put(bfather,asize+bsize);
                }
            }
        }



}
