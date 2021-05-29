package algorithm.leetcode.dynamic;

/**
 * 91. 解码方法
 * @Author: Xiongyy
 * @Date: 2021/4/21 20:11
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class DecodeWays91 {

    public int numDecodings(String s) {
        int length = s.length();
        if (length < 1) {
            return 0;
        }

        int[] dp = new int[length + 1];
        //主要作为前导0,避免下面的判断比较复杂
        s = " " + s;
        dp[0] = 1;
        char[] cs = s.toCharArray();
        for (int i = 1; i <= length; i++) {
            // a : 代表「当前位置」单独形成 item
            // b : 代表「当前位置」与「前一位置」共同形成 item
            int a = cs[i] - '0', b = (cs[i - 1] - '0') * 10 + (cs[i] - '0');
            // 如果 a 属于有效值，那么 f[i] 可以由 f[i - 1] 转移过来
            if (1 <= a && a <= 9) dp[i] = dp[i - 1];
            // 如果 b 属于有效值，那么 f[i] 可以由 f[i - 2] 或者 f[i - 1] & f[i - 2] 转移过来
            if (10 <= b && b <= 26) dp[i] += dp[i - 2];
        }
        return dp[length];
    }

    public int numDecoding2(String s) {
        int length = s.length();
        if (length < 1 || s.startsWith("0")) {
            return 0;
        }
        int pre = 1, curr = 1;

        for (int i = 1; i < s.length(); i++) {
            int tmp = curr;
            if (s.charAt(i) == '0') {
                if (i == 1) {
                    return 0;
                }
                if (s.charAt(1 - 1) == '1' || s.charAt(1 - 1) == '2') {
                    curr = pre;
                }
            }else if ((s.charAt(i -1) == '1' || s.charAt(i -1) == '2') &&  s.charAt(i) >= '1' && s.charAt(i) <= '6') {
                curr = curr + pre;
            }
            pre = tmp;
        }
        return curr;
    }
}
