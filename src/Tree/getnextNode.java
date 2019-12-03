package Tree;

import problems.Node;

//找寻后继节点
public class getnextNode {
      public static Node getSuccessorNode(Node node)
      {
          if(node==null)
          {
              return  node;
          }
          if(node.right!=null)
          {
              return getLeftMost(node.right);
          }
          else
          {
              Node parent=node.parent;
              while (parent != null && parent.left != node) {
                            node=parent;
                            parent=node.parent;
              }
              return parent;
          }
      }

    private static Node getLeftMost(Node node) {

        while (node.left!=null)
        {
            node=node.left;
        }
        return  node;
    }
}
