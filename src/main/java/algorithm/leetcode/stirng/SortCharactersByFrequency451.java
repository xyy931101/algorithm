package algorithm.leetcode.stirng;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author: xiongyayun
 * @date: 2021/7/3 13:31
 */
public class SortCharactersByFrequency451 {

    class Node {
        char c;
        int v;
        Node(char _c, int _v) {
            c = _c; v = _v;
        }
    }
    public String frequencySort(String s) {
        char[] cs = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : cs) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Node> q = new PriorityQueue<>((a, b)->{
            if (b.v != a.v) return b.v - a.v;
            return a.c - b.c;
        });
        for (char c : map.keySet()) {
            q.add(new Node(c, map.get(c)));
        }
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            Node poll = q.poll();
            int k = poll.v;
            while (k-- > 0) sb.append(poll.c);
        }
        return sb.toString();
    }
}
