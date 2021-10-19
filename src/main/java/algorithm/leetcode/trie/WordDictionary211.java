package algorithm.leetcode.trie;

/**
 * 211. 添加与搜索单词 - 数据结构设计
 * @author: xiongyayun
 * @date: 2021/10/19 7:28 下午
 */
public class WordDictionary211 {

    class Node {
        Node[] children = new Node[26];
        boolean isEnd;
    }
    Node root;
    public WordDictionary211() {
        root = new Node();
    }

    public void addWord(String word) {
        Node p = root;
        char[] chars = word.toCharArray();
        for (char ch : chars) {
            int index = ch - 'a';
            if (p.children[index] == null) p.children[index] = new Node();
            p = p.children[index];
        }
        p.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, Node node) {
        if (index == word.length()) {
            return node.isEnd;
        }
        char ch = word.charAt(index);
        if (ch == '.') {
            for (Node child : node.children) {
                if (child != null && dfs(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        }else {
            if (node.children[ch - 'a'] == null) return false;
            return dfs(word, index + 1, node.children[index]);
        }

    }
}
