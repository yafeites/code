package dynamic;

import java.util.Map;

public class MaxProduct {
       public static  int  maxProduct(int []num)
       {
            int max=num[0];
            int min=num[0];
            for (int i=0;i<num.length;i++)
            {
                int maxend=max*num[i];
                int minend=min*num[i];
                max= Math.max(Math.max(maxend,minend),num[i]);
                min= Math.min(Math.min(maxend,minend),num[i]);
            }
            return max;
       }
}
