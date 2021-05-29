package algorithm.leetcode.array;

import java.util.*;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。
 * 字母异位词指字母相同，但排列不同的字符串。
 * @Author: Xiongyy
 * @Date: 2021/4/4 13:31
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class GroupAnagrams {

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        List<List<String>> lists = groupAnagrams.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(lists);
    }


    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length < 1) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> anagrams = map.getOrDefault(key, new ArrayList<>());
            anagrams.add(strs[i]);
            map.put(key, anagrams);
        }
        return new ArrayList<>(map.values());
    }
}
