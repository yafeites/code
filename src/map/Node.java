package map;




import java.util.ArrayList;

public class Node {
    public int value;
    public int in ;
    public int out;
    public ArrayList<Node>nexts;
//    表示该Node为from的情况下出发所拥有的edges
    public ArrayList<Edge>edges;
    public Node(int value)
    {
        this.value=value;
        in=0;
        out=0;
        nexts=new ArrayList<>();
        edges=new ArrayList<>();
    }
}
