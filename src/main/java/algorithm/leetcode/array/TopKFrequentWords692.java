package algorithm.leetcode.array;

import java.util.*;

/**
 * 692. 前K个高频单词
 * @author xiongyayun
 * @date 2021/5/20 8:34
 */
public class TopKFrequentWords692 {

    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();

        if (words == null || words.length == 0) return  res;

        Map<String, Integer> countMap = new HashMap<>();
        for (String word : words) {
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((entry1, entry2) ->
                entry1.getValue() == entry2.getValue() ? entry2.getKey().compareTo(entry1.getKey()) : entry1.getValue() - entry2.getValue());

        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        while (!pq.isEmpty()) {
            res.add(pq.poll().getKey());
        }
        Collections.reverse(res);
        return res;
    }
}
