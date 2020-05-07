package leetcode;

/**
 * @program: code
 * @description: LeetCode460
 * @author: Mr.Wang
 * @create: 2020-04-24 21:10
 **/

import jdk.nashorn.internal.ir.IdentNode;

import java.util.HashMap;
import java.util.Map;
    /**
    * @Description: 利用map结构,一个map用于key对应的node节点,一个mao用于存放对应引用次数的key的双向链表
    * @Param:
    * @return:
    * @Author: Mr.Wang
    * @Date: 2020/4/25
    */
public class LFUCache {
    //["LFUCache","put","put","get","put","get","get","put","get","get","get"]
    //[[2],[1,1],[2,2],[1],[3,3],[2],[3],[4,4],[1],[3],[4]]
    public static void main(String[] args) {
        LFUCache lfuCache=new LFUCache(2);
        lfuCache.put(1,1);
        lfuCache.put(2,2);
        lfuCache.get(1);
        lfuCache.put(3,3);
        lfuCache.get(2);
        lfuCache.get(3);
        lfuCache.put(4,4);
        lfuCache.get(1);
        lfuCache.get(3);
        lfuCache.get(4);
    }
    Map<Integer,Node>keyMap;
    Map<Integer,DequeList>frequentMap;
    int size;
    int capacity;
    int minfrequent;
    public LFUCache(int capacity) {
        keyMap=new HashMap<>();
        frequentMap=new HashMap<>();
        this.capacity=capacity;
        minfrequent=1;
        size=0;
    }
        /**
        * @Description:  移除相应节点,并将此节点放入新的对应的引用次数的双向链表中
        * @Param:
        * @return:
        * @Author: Mr.Wang
        * @Date: 2020/4/25
        */
    public int get(int key) {

        if(!keyMap.containsKey(key))
            {
                return  -1;
            }
        Node node =removeListNode(key);
        move2head(node.cnt,node);
        return  node.val;
    }
        /**
        * @Description: 如果对应node不存在则判断是否需要删除最低引用次数的双向链表的尾部节点存在则和get操作相似
        * @Param:
        * @return:
        * @Author: Mr.Wang
        * @Date: 2020/4/25
        */
    public void put(int key, int value) {
        if(capacity==0)
        {
            return;
        }
        Node node =keyMap.get(key);
        if(node==null)
        {
            if(size==capacity)
            {
                DequeList list=frequentMap.get(minfrequent);
                Node deletenode=list.removeTail();
                keyMap.remove(deletenode.key);
                size--;
            }
            node=new Node();
            node.val=value;
            node.key=key;
            move2head(1,node);
            keyMap.put(key,node);
            minfrequent=1;
            size++;

        }
        else
        {
            node.val=value;
            removeListNode(key);
            move2head(node.cnt,node);

        }
    }
    class Node {
        Node pre;
        Node next;
        int key;
        int val;
        int cnt=1;


    }
    class DequeList
    {
        Node tail;
        Node head;
        int cnt;
        public DequeList() {
            tail=new Node();
            head=new Node();
            tail.pre=head;
            head.next=tail;
            cnt=0;
        }
        void go2Head(Node node)
        {
            Node next=head.next;
            next.pre=node;
            node.next=next;
            node.pre=head;
            head.next=node;
            cnt++;
        }
        void remove(Node node)
        {
            Node next=node.next;
            next.pre=node.pre;
            node.pre.next=next;
            cnt--;
        }
        Node removeTail()
        {
            Node deleteNode=tail.pre;
            tail.pre=deleteNode.pre;
            deleteNode.pre.next=tail;
            cnt--;
            deleteNode.next=null;
            deleteNode.pre=null;
            return  deleteNode;
        }
    }
     DequeList findList(int cnt)
     {
         DequeList list=frequentMap.get(cnt);
         if(list!=null)
         {
             return list;
         }
         list=new DequeList();
         frequentMap.put(cnt,list);
         return list;
     }
        /**
        * @Description: 如果删除掉结点后此双向链表已经没有结点并且链表的引用次数和目前最低的引用次数相同,则需要将最低引用次数+1,
         * 因为出现这种情况是在get和put操作的一部分情况出现的,所以会被删除结点放入引用次数+1的链表中
        * @Param:
        * @return:
        * @Author: Mr.Wang
        * @Date: 2020/4/25
        */
     Node removeListNode(int key)
     {
         Node node=keyMap.get(key);
         DequeList list=frequentMap.get(node.cnt);
         list.remove(node);
         if(list.cnt==0&&node.cnt==minfrequent)
         {
             minfrequent++;
         }
         node.cnt++;
         return  node;
     }
     void move2head(int cnt,Node node)
     {
         DequeList list=findList(cnt);
         list.go2Head(node);
     }

}

