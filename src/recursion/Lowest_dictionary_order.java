package recursion;

import java.util.Arrays;
import java.util.Comparator;

public class Lowest_dictionary_order {
    public  static  String lowestString(String[]strs)
    {
        if(strs==null||strs.length==0)
        {
            return  "";
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1+o2).compareTo(o2+o1);
            }
        });
        String res="";
        for(int i=0;i<strs.length;i++)
        {
            res+=strs[i];
        }
        return res;
    }

}
