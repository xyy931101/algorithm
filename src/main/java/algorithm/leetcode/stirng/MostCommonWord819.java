package algorithm.leetcode.stirng;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 819. 最常见的单词
 * @author: xiongyayun
 * @date: 2022/4/17 13:13
 */
public class MostCommonWord819 {

    public static void main(String[] args) {
        System.out.println(mostCommonWord(
                "Bob hit a ball, the hit BALL flew far after it was hit.", new String[] {"hit"}));
    }


    public static String mostCommonWord(String paragraph, String[] banned) {
        Set<String> banset = new HashSet<String>();
        for(String s : banned) banset.add(s);
        char[] str = paragraph.toCharArray();
        Map<String, Integer> count = new HashMap<>();
        String res = null;
        for(int i = 0; i < str.length; ){
            while(i < str.length && !Character.isLetter(str[i])) {
                i++;
            }

            int end = i;
            while(end < str.length && Character.isLetter(str[end])) end++;
            String sub = paragraph.substring(i, end).toLowerCase();
            i = end + 1;
            if (banset.contains(sub)) continue;
            count.put(sub, count.getOrDefault(sub, 0) + 1);
            if(res == null || count.get(res) < count.get(sub)) res = sub;

        }
        return res;
    }
}
