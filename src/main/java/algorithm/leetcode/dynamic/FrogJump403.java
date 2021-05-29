package algorithm.leetcode.dynamic;

/**
 * 403. 青蛙过河
 * @Author: Xiongyy
 * @Date: 2021/4/29 8:36
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class FrogJump403 {

    public boolean canCross(int[] stones) {
        if (stones == null ||stones.length <= 1) {
            return true;
        }
        int length = stones.length;
        boolean[][]dp = new boolean[length][length];

        for (int i = 1; i < length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                //上一次跳的距离
                int k = stones[i] - stones[j];
                //如果跳的大于前面的所有,则没有必要了
                if (k > j + 1) {
                    break;
                }
                dp[i][k] = dp[j][k - 1] || dp[j][k] || dp[j][k + 1];
                if (i == length - 1 && dp[i][k]) {
                    return true;
                }
            }

        }
        return false;
    }

}
