package algorithm.leetcode.array;

import sun.nio.ch.Net;

import java.util.*;

/**
 * 127. 单词接龙
 * @author: xiongyayun
 * @date: 2021/9/15 9:59 下午
 */
public class WordLadder127 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);

        Map<String, List<String>> nexts = getNexts(wordList);

        HashMap<String, Integer> distanceMap = new HashMap<>();
        distanceMap.put(beginWord, 1);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        //宽度优先遍历,算出最近距离
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            Integer distance = distanceMap.get(cur);
            for (String next : nexts.get(cur)) {
                if (next.equals(endWord)) {
                    return distance + 1;
                }
                if (!distanceMap.containsKey(next)) {
                    distanceMap.put(next, distance + 1);
                    queue.add(next);
                }
            }
        }
        return 0;
    }

    private Map<String, List<String>> getNexts(List<String> wordList) {
        HashMap<String, List<String>> nexts =  new HashMap<>();
        Set<String> dicts = new HashSet<>(wordList);
        dicts.forEach(word ->{
            nexts.put(word, getNext(word, dicts));
        });
        return nexts;
    }

    private List<String> getNext(String word, Set<String> dicts) {
        char[] chars = word.toCharArray();
        List<String> res = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (c != ch) {
                    chars[i] = ch;
                    String s = String.valueOf(chars);
                    if (dicts.contains(s)) {
                        res.add(s);
                    }
                }
                //还原
                chars[i] = c;
            }
        }
        return res;
    }
}
