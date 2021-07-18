package algorithm.leetcode.dynamic;

/**
 * @author xiongyayun
 * @date 2021/5/15 23:29
 */
public class TargetSum494 {

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
            sum += nums[i];
        // 绝对值范围超过了sum的绝对值范围则无法得到
        if (Math.abs(target) > Math.abs(sum)) return 0;
        int len = nums.length;

        //因为要包含负数所以要两倍，又要加上0这个中间的那个情况
        int range = sum * 2 + 1;
        //这个数组是从总和为-sum开始的
        int[][] dp = new int[len][range];
        //加上sum纯粹是因为下标界限问题，赋第二维的值的时候都要加上sum
        // 初始化   第一个数只能分别组成+-nums[i]的一种情况
        dp[0][sum + nums[0]] += 1;
        dp[0][sum - nums[0]] += 1;
        for (int i = 1; i < len; i++) {
            for (int j = -sum; j <= sum; j++) {
                if ((j + nums[i]) > sum) {//+不成立 加上当前数大于了sum   只能减去当前的数
                    dp[i][j + sum] = dp[i - 1][j - nums[i] + sum] + 0;
                } else if ((j - nums[i]) < -sum) {//-不成立  减去当前数小于-sum   只能加上当前的数
                    dp[i][j + sum] = dp[i - 1][j + nums[i] + sum] + 0;
                } else {//+-都可以
                    dp[i][j + sum] = dp[i - 1][j + nums[i] + sum] + dp[i - 1][j - nums[i] + sum];
                }
            }
        }
        return dp[len - 1][sum + target];
    }
}
