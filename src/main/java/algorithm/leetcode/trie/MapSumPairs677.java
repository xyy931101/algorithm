package algorithm.leetcode.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * 677. 键值映射
 * @author: xiongyayun
 * @date: 2021/11/14 10:27
 */
public class MapSumPairs677 {

    public Node root;
    Map<String, Integer> map;
    public MapSumPairs677() {
        this.root = new Node();
        map = new HashMap<>();
    }

    public static void main(String[] args) {
        MapSumPairs677 mapSum = new MapSumPairs677();
        mapSum.insert("apple", 3);
        mapSum.insert("app", 2);
        mapSum.insert("apple", 3);
        System.out.println(mapSum.sum("ap"));
    }

    public void insert(String key, int val) {
        int delta = val - map.getOrDefault(key, 0);
        map.put(key, val);
        Node node = root;
        char[] chars = key.toCharArray();
        for (char ch : chars) {
            Node cur = node.children[ch - 'a'];
            if (cur == null) {
                cur = new Node();
            }
            cur.sum = cur.sum  + delta;
            node.children[ch - 'a'] = cur;
            node = cur;
        }
    }

    public int sum(String prefix) {
        Node node = root;
        char[] chars = prefix.toCharArray();
        for (char ch : chars) {
            node = node.children[ch - 'a'];
            if (node == null) return 0;
        }
        return node.sum;
    }

    public static class Node{
        Node[] children = new Node[26];
        int sum;
    }


}
