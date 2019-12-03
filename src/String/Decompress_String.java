package String;
//将类似于3{ab2{a}}转换成abaaabaa
public class Decompress_String {
    public  static  String decompress(String s)
    {
        char[]chs=s.toCharArray();
        return process(chs,0).str;
    }
    static class ReturnData
    {
        public String str;
        public int end;
        public ReturnData(String str, int end) {
            this.str = str;
            this.end = end;
        }
    }
    private static ReturnData process(char[] chs, int i) {
        StringBuilder stringBuilder=new StringBuilder();
//        终止的提示符为到string尾部或者遇到一个}该返回
        while (i<chs.length&&chs[i]!='}')
        {
            int time=0;
//            如果下一个字符是{则进入递归,根据返回来的索引就行循环
            if(chs[i]=='{')
            {
                ReturnData returnData=process(chs,i+1);
                stringBuilder.append(doublehappy(time,returnData.str));
                i=returnData.end+1;
            }
            else
            {
//                求time活动
                if (chs[i]>='0'&&chs[i]<='9')
                {
                    time=10*time+chs[i]-'0';
                }
//                正常字符直接加入即可
                else
                {
                    stringBuilder.append(chs[i]);
                }
                i++;
            }


        }
        return  new ReturnData(stringBuilder.toString(),i);
    }

    private static StringBuilder doublehappy(int time, String str) {
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=0;i<time;i++)
        {
            stringBuilder.append(str);
        }
        return  stringBuilder;
    }
}
