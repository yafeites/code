package map;
//构造前缀树

public class TrieNode {
//    end表示在此node位置结尾的地方
//    pass表示有多少词划过该node,方便进行删除的时候判断如果如果已经没有词划过该node则将结点删除
    public int pass;
    public int end;
    public TrieNode[] nexts;
    public TrieNode()
    {
        pass=0;
        end=0;
        nexts=new TrieNode[26];
    }
    public static class Tire
    {
        private TrieNode root;
        public Tire()
        {
            root=new TrieNode();
        }
        public void insert(String word)
        {
            if (word==null)
            {
                return;
            }
            char[]chs=word.toCharArray();
            TrieNode node=root;
            int index=0;
            for(int i=0;i<chs.length;i++)

            {
                index=chs[i]-'a';
                if(node.nexts[index]==null)
                {
                    node.nexts[index]=new TrieNode();
                }
                node=node.nexts[index];
                node.pass++;
            }
            node.end++;
        }
        public void delete(String word)
        {
            if(search(word))
            {
                char[] chs=word.toCharArray();
                TrieNode node = root;
                int index = 0;
                for(int i=0;i<chs.length;i++)
                {
                    index=chs[i]-'a';
                    if(node.nexts[index].pass==1)
                    {
                        node.nexts[index]=null;
                        return;
                    }
                    node=node.nexts[index];
                }
                node.end--;
            }

        }

        public int prefixNumber(String pre)
        {
                if(pre==null)
                {
                    return  0;
                }
                char[] chs= pre.toCharArray();
                TrieNode node=root;
                int index=0;
                for(int i=0;i<chs.length;i++)
                {
                    index=chs[i]-'a';
                    if(node.nexts[index]==null)
                    {
                        return 0;
                    }
                    node=node.nexts[index];
                }
                return  node.pass;
        }
        private boolean search(String word) {
            if(word==null)
            {
                return  false;
            }
            char[] chs=word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.nexts[index] == null) {
                    return false;
                }
                node = node.nexts[index];
            }
            return node.end != 0;
        }
    }
}
