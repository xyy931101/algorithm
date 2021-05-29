package algorithm.leetcode.dynamic;

import com.alibaba.fastjson.JSONObject;

/**
 * 面试题 17.09. 第 k 个数
 * @Author: Xiongyy
 * @Date: 2021/4/20 21:48
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class GetKthMagicnumberlcci {

    public static void main(String[] args) {
        GetKthMagicnumberlcci g = new GetKthMagicnumberlcci();

        System.out.println(g.getKthMagicNumber(10));
    }

    public int getKthMagicNumber(int k) {
        if (k < 1) {
            return 0;
        }
        int[] dp = new int[k];

        dp[0] = 1;
        int index3 = 0, index5 = 0, index7 = 0;
        for (int i = 1; i < k; i++) {
            dp[i] = Math.min(Math.min(dp[index3] * 3, dp[index5] * 5), dp[index7] * 7);
            if ( dp[i] == dp[index3] * 3) {
                index3 ++;
            }
            if (dp[i] == dp[index5] * 5) {
                index5 ++;
            }

            if (dp[i] == dp[index7] * 7) {
                index7++;
            }

        }

        System.out.println(JSONObject.toJSONString(dp));
        return dp[k - 1];
    }
}
