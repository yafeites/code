package leetcode;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: code
 * @description: LeetCode199
 * @author: Mr.Wang
 * @create: 2020-04-29 18:15
 **/

public class BinaryTreeRightSideView {
    class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer>list=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        if(root==null)
        {
            return list;
        }
        queue.add(root);
        while (!queue.isEmpty())
        {
            int size=queue.size();
            for(int i=0;i<size;i++)
            {
                TreeNode node=queue.poll();
                if(node.left!=null)
                {
                    queue.add(node.left);
                }
                if(node.right!=null)
                {
                    queue.add(node.right);
                }
                if(i==size-1)
                {
                    list.add(node.val);
                }
            }
        }
        return list;

    }
}
