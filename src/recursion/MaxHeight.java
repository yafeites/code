package recursion;

import problems.Node;
//假设二叉树上两点的最短距离为其距离,求此二叉树上两点的最长距离
public class MaxHeight {
    public  static returnType fun(Node node)
    {
        if(node==null)
        {
            return new returnType(0,0);

        }
        returnType returnTypeleft=fun(node.left);
        returnType returnTypeRight=fun(node.right);
        int maxdistance=Math.max(Math.max(returnTypeleft.maxdistance,returnTypeRight.maxdistance),returnTypeleft.height+1+returnTypeRight.height);
        int height=Math.max(returnTypeleft.height,returnTypeRight.height);
        return  new returnType(height,maxdistance);
    }
    static class returnType
    {
        int height;
        int maxdistance;

        public returnType(int height, int maxdistance) {
            this.height = height;
            this.maxdistance = maxdistance;
        }
    }
}
