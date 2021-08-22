package algorithm.leetcode.trie;

/**
 * 135. 分发糖果
 *
 * @author: xiongyayun
 * @date: 2021/8/22 9:23
 */
public class Candy135 {

    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        int N = ratings.length;
        int candy = 1;
        int[] lDp = new int[N];
        lDp[0] = 1;
        for (int i = 1; i < N; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candy++;
            } else {
                candy = 1;
            }
            lDp[i] = candy;
        }
        int[] rDp = new int[N];
        rDp[N - 1] = 1;
        candy = 1;
        for (int i = N - 2; i >= 0; i--) {
            if (ratings[i - 1] > ratings[i]) {
                candy++;
            } else {
                candy = 1;
            }
            rDp[i] = candy;
        }
        int ans = 0;
        for (int i = 0; i < N; i++) {
            ans += Math.max(lDp[i], rDp[i]);
        }
        return ans;
    }
}
