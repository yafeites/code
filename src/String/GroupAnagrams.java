package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//将string数组中属于排序后相同的string放入一个String list中
public class GroupAnagrams {
    public  static List<List<String>>  getGroupAnagrams(String[]strs)
    {
        HashMap<String ,List<String >>map=new HashMap<>();
        List<List<String>>res=new ArrayList<>();
        for(String s:strs)
        {
            char[]chs=s.toCharArray();
            int []help=new int[26];
            for(int i=0;i<chs.length;i++)
            {
                help[chs[i]-'a']++;
            }
            StringBuilder stringBuilder=new StringBuilder();
            for(int i=0;i<help.length;i++)
            {
                stringBuilder.append(help[i]).append("_");
            }
            String key=stringBuilder.toString();
            if(!map.containsKey(key))
            {
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(s);
        }
        for(List list:map.values())
        {
            res.add(list);
        }
        return  res;
    }
}
