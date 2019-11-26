package map;

import java.util.*;

public class Word__Ladder {
    public  static  List<List<String>> findLadders(String begingword,String endword,List<String>wordList)
    {
        wordList.add(begingword);
        HashMap<String, ArrayList<String >>nexts=getnexts(wordList);
        HashMap<String,Integer>distance=getDistance(begingword,nexts);
        LinkedList<String>solution=new LinkedList<>();
        List<List<String>>res=new ArrayList<>();
        getshortestdistance(begingword,endword,nexts,distance,solution,res);
        return res;
    }

    private static void getshortestdistance(String begingword, String endword, HashMap<String,
            ArrayList<String>>  nexts, HashMap<String, Integer> distance,
                                            LinkedList<String> solution, List<List<String>> res) {

         solution.add(begingword);
         if(begingword==endword)
         {
             res.add(solution);
         }
         else
         {
             for(String s:nexts.get(begingword))
             {
                 if(distance.get(s)==distance.get(begingword)+1)
                 {
                     getshortestdistance(s,endword,nexts,distance,solution,res);
                 }
             }
         }
         solution.pollLast();

    }

    private static HashMap<String, Integer> getDistance(String begingword, HashMap<String, ArrayList<String >>nexts) {
        HashMap<String,Integer>res=new HashMap<String, Integer>();
        HashSet<String>visited=new HashSet<>();
        Queue<String>queue=new LinkedList<>();
        queue.add(begingword);
        res.put(begingword,0);
        while (!queue.isEmpty())
        {
            String s=queue.poll();
            if(!visited.contains(s))
            {

                for(String next:nexts.get(s))
                {
                    queue.add(next);
                    res.put(next,res.get(s)+1);
                }
            }
        }
        return  res;

    }

    private static HashMap<String, ArrayList<String>> getnexts(List<String> wordList) {
        HashMap<String,ArrayList<String>>res=new HashMap<>();
        for(int i=0;i<wordList.size();i++)
        {
            res.put(wordList.get(i),new ArrayList<>());

        }
        for(int i=0;i<wordList.size();i++)
        {
            res.put(wordList.get(i),getnext(wordList.get(i),wordList));
        }
        return  res;
    }

    private static ArrayList<String> getnext(String s, List<String> wordList) {
        ArrayList<String>res=new ArrayList<>();
        char[] chs=s.toCharArray();
        for(int i=0;i<chs.length;i++)
        {
            for(char cur='a';cur<='z';cur++)
            {
                if(chs[i]!=cur)
                {
                    char temp=chs[i];
                    chs[i]=cur;
                    if(wordList.contains(String.valueOf(chs)))
                    {
                        res.add(String.valueOf(chs));
                    }
                    chs[i]=temp;
                }
            }
        }
        return  res;
    }
}
