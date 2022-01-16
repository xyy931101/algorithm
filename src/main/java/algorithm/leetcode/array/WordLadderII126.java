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
        wordList.add(beginWord);
        List<List<String>> res = new ArrayList<>();
        if(!wordList.contains(endWord)){
            return res;
        }
        Map<String, List<String>> nexts = getNexts(wordList);
        Map<String, Integer> distanceMap = getDistances(beginWord, nexts);

        LinkedList<String> path = new LinkedList();
        getShortestPaths(beginWord, endWord, nexts, distanceMap, res, path);
        return res;
    }

    public static void getShortestPaths(String cur, String to, Map<String, List<String>> nexts, Map<String, Integer> distanceMap, List<List<String>> res, LinkedList<String> path){
        path.add(cur);
        if(cur.equals(to)){
            res.add(new LinkedList<>(path));
        }else {
            for(String next : nexts.get(cur)){
                if(distanceMap.get(next) == distanceMap.get(cur) + 1){
                    getShortestPaths(next, to, nexts, distanceMap, res, path);
                }
            }
        }
        path.pollLast();
    }

    /*public static Map<String, Integer> getDistances(String beginWord, Map<String, List<String>> nexts){
        HashMap<String, Integer> distanceMap = new HashMap<>();
        //先将自己放进去,避免重复走
        distanceMap.put(beginWord, 0);
        LinkedList<String> deque = new LinkedList();
        deque.add(beginWord);
        while(!deque.isEmpty()){
            String cur = deque.poll();
            Integer curDistance = distanceMap.get(cur);
            for(String next : nexts.get(cur)){
                if(!distanceMap.containsKey(next)){
                    distanceMap.put(next, curDistance + 1);
                    deque.add(next);
                }
            }
        }
        return distanceMap;
    }*/

    private static HashMap<String, Integer> getDistances(String beginWord, Map<String, List<String>> nexts) {
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

    public static Map<String, List<String>> getNexts(List<String> wordList){
        Set<String> dicts = new HashSet<>(wordList);
        Map<String, List<String>> nexts = new HashMap<String, List<String>>();
        for(String word : wordList){
            nexts.put(word, getNext(word, dicts));
        }
        return nexts;
    }

    public static List<String> getNext(String word, Set<String> dicts){
        char[] chars = word.toCharArray();
        List<String> res = new LinkedList<String>();
        for(int i = 0; i <= chars.length - 1; i++){
            char c = chars[i];
            for(char ch = 'a'; ch <= 'z'; ch++){
                if(ch != c){
                    chars[i] = ch;
                    String s = String.valueOf(chars);
                    if(dicts.contains(s)){
                        res.add(s);
                    }
                }
            }
            chars[i] = c;
        }
        return res;
    }
}
