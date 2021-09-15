package algorithm.leetcode.dynamic;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 139. 单词拆分
 * @author xiongyayun
 * @date 2021/5/12 20:22
 */
public class WordBreak139 {

    public static void main(String[] args) {
        WordBreak139 w = new WordBreak139();
        System.out.println(w.wordBreak("aaaaaaa", Arrays.asList("aaaa","aaa")));
    }

    //使用前缀树
    public static class Tire{
        boolean end;
        Tire[] nexts;

        public Tire(){
            end = false;
            nexts = new Tire[26];
        }
    }

    //应该算是最优解
    public boolean wordBreak(String s, List<String> wordDict) {
        //先构建前缀树
        Tire tire = new Tire();
        wordDict.forEach(word ->{
            char[] chars = word.toCharArray();
            Tire node = tire;
            for (int i = 0; i < chars.length; i++) {
                int index = chars[i] - 'a';
                if (node.nexts[index] == null) {
                    node.nexts[index] = new Tire();
                }
                node = node.nexts[index];
            }
            node.end = true;
        });
        char[] chars = s.toCharArray();
        int N = s.length();
        boolean[] dp = new boolean[N + 1];
        dp[N] = true;
        for (int i = N - 1; i >= 0; i--) {
            Tire cur = tire;
            for (int j = i; j < N; j++) {
                cur = cur.nexts[chars[j] - 'a'];
                //如果当前字符没有路径,就没有走的必要了
                if (cur == null) break;
                if (cur.end) {
                    dp[i] |= dp[j + 1];
                }
                if (dp[i]) break;
            }
        }
        return dp[0];
    }

    public boolean wordBreak1(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
