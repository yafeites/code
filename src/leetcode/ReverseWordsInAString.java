package leetcode;

import recursion.ReverseStackUsingRecursive;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @program: code
 * @description: LeetCode151
 * @author: Mr.Wang
 * @create: 2020-04-25 15:45
 **/

public class ReverseWordsInAString {
    public static void main(String[] args) {
        String s="  a  bc d";
        String strs[]=s.split("\\s+");
        System.out.println(strs.length);
        for(int i=0;i<strs.length;i++)
        {
            System.out.println(strs[i]);
        }
        ReverseWordsInAString reverseWordsInAString=new ReverseWordsInAString();
        reverseWordsInAString.reverseWords("the sky is blue");
    }
    public String reverseWords(String s) {
        s=s.trim();
        List<String> strs= Arrays.asList(s.split("\\s+"));
        Collections.reverse(strs);
        return  String.join(" ",strs);
    }
}
