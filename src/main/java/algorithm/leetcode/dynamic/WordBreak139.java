package algorithm.leetcode.dynamic;

import java.util.List;

/**
 * 139. 单词拆分
 * @author xiongyayun
 * @date 2021/5/12 20:22
 */
public class WordBreak139 {

    public boolean wordBreak(String s, List<String> wordDict) {
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
