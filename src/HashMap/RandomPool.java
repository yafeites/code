package HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

//设计RandomPool insert,delete,getrandom都为O(1)复杂度的方法
public class RandomPool {
//    构造2个hashmap,第一个key，value为存入的string和index，第二个为index和string.
//      每次delete时,判断是否为最后一个加入的元素,如果不是则将最后一个index对应的string与其替换，再删除最后一个元素即可.
   Map<String ,Integer>map1;
   Map<Integer,String> map2;
   int index;
    public RandomPool() {
        map1=new HashMap<>();
        map2=new HashMap<>();
        index=1;
    }
    public  void insert(String s)
    {
        map1.put(s,index);
        map2.put(index++,s);
    }
    public  void delete(String s)
    {
        if(!map1.containsKey(s))
        {
            throw  new RuntimeException("没有找到要删除的元素");
        }
        int value=map1.get(s);
        if(value!=index)
        {
            String temp=map2.get(index);
            map1.put(temp,value);
            map2.put(value,temp);
        }
        map1.remove(s);
        map2.remove(index--);
    }
    public String getRandom()
    {
        Random r=new Random();
        return map2.get(r.nextInt(index)+1);
    }
}
