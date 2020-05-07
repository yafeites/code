package recursion;

import problems.Node;

public class isBalance {
    public  static  returnType fun(Node node)
    {
        if(node==null)
        {
            return new returnType(0,true);

        }
        returnType returnTypeleft=fun(node.left);
        returnType returnTypeRgiht=fun(node.right);
        boolean isB=returnTypeleft.isB&&returnTypeRgiht.isB&&
                (Math.abs(returnTypeleft.height-returnTypeRgiht.height)<=1);
        return  new returnType(Math.max(returnTypeleft.height,returnTypeleft.height),isB);
    }
    static  class  returnType
    {
        public returnType(int height, boolean isB) {
            this.height = height;
            this.isB = isB;
        }

        int height;
        boolean isB;
    }

}
