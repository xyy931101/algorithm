package algorithm.leetcode.array;

import java.util.*;

/**
 * 编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。
 * 变位词是指字母相同，但排列不同的字符串。
 * @author: xiongyayun
 * @date: 2021/7/18 17:50
 */
public class GroupAnagramsLcci {


    public static void main(String[] args) {
        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            List<String> exists = map.getOrDefault(key, new ArrayList<>());
            exists.add(str);
            map.put(key, exists);
        }
        List<List<String>> ans = new ArrayList<>();
        map.forEach((k, v) -> ans.add(v));
        return ans;
    }
}
