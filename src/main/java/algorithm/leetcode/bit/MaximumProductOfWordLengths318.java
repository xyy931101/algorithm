package algorithm.leetcode.bit;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 318. 最大单词长度乘积
 * @author: xiongyayun
 * @date: 2021/11/17 8:34
 */
public class MaximumProductOfWordLengths318 {

    public int maxProduct(String[] words) {
        Map<Integer, Integer> map = new HashMap<>();
        for (String word : words) {
            int msk = 0;
            for (char c : word.toCharArray()) {
                msk |= 1 << (c - 'a');
            }
            if (!map.containsKey(msk) || map.get(msk) < word.length()) {
                 map.put(msk, word.length());
            }
        }
        Set<Integer> keySet = map.keySet();
        int ans = 0;
        for (Integer msk : keySet) {
            for (Integer msk1 : keySet) {
                if ((msk & msk1) == 0) {
                    ans = Math.max(ans, map.get(msk) * map.get(msk1));
                }
            }
        }
        return ans;
    }
}
