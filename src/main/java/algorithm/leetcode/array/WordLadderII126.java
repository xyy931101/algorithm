package algorithm.leetcode.array;

import java.util.*;

/**
 * 126. 单词接龙 II
 * @author: xiongyayun
 * @date: 2021/9/12 7:28 下午
 */
public class WordLadderII126 {

    public static void main(String[] args) {

        System.out.println(findLadders("hit",
                "cog",
                        new ArrayList<String>(Arrays.asList("hot","dot","dog","lot","log","cog"))));
    }

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        //先将begin添加进去
        wordList.add(beginWord);
        //构建邻居表
        HashMap<String, List<String>> nexts = getNexts(wordList);
        //构建邻居距离表
        HashMap<String, Integer> distances = getDistances(beginWord, nexts);

        LinkedList<String> pathList = new LinkedList<>();
        List<List<String>> res = new ArrayList<>();
        getShortestPaths(beginWord, endWord, nexts, distances, pathList, res);
        return res;
    }

    private static void getShortestPaths(String cur, String to, HashMap<String, List<String>> nexts, HashMap<String, Integer> distances, LinkedList<String> path, List<List<String>> res) {
        path.add(cur);
        if (to.equals(cur)) {
            res.add(new LinkedList<>(path));
        } else {
            //遍历所有的相邻字符串,找到符合条件的
            for (String next : nexts.get(cur)) {
                if (distances.get(next) == distances.get(cur) + 1) {
                    getShortestPaths(next, to, nexts, distances, path, res);
                }
            }
        }
        path.pollLast();
    }

    private static HashMap<String, Integer> getDistances(String beginWord, HashMap<String, List<String>> nexts) {
        HashMap<String, Integer> distances = new HashMap<>();
        //先将自己放进去,避免重复走
        distances.put(beginWord, 0);
        //宽度优先遍历,构建距离表
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            Integer curDis = distances.get(cur);
            for (String next : nexts.get(cur)) {
                //避免重复走
                if (!distances.containsKey(next)) {
                    distances.put(next, curDis + 1);
                    queue.add(next);
                }
            }
        }
        return distances;
    }

    private static HashMap<String, List<String>> getNexts(List<String> wordList) {
        HashMap<String, List<String>> nexts =  new HashMap<>();
        HashSet<String> dict = new HashSet<>(wordList);
        for (String word : wordList) {
            nexts.put(word, getNext(word, dict));
        }
        return nexts;
    }
    //获取所有的相邻字符串
    private static List<String> getNext(String word, Set<String> dict) {
        char[] chars = word.toCharArray();
        List<String> next = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            for (char cur = 'a'; cur <= 'z'; cur++) {
                if (ch != cur) {
                    chars[i] = cur;
                    String s = String.valueOf(chars);
                    if (dict.contains(s)){
                        next.add(s);
                    }
                }
            }
            //还原回去
            chars[i] = ch;
        }
        return next;
    }
}
