package algorithm.leetcode.dynamic;

/**
 * @author: xiongyayun
 * @date: 2021/7/6 10:23 下午
 */
public class PartitionEqualSubsetSum416 {

    public static void main(String[] args) {
        System.out.println(canPartition(new int[] {1,5,11,5}));
    }

    public static boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) return false;

        int sum = 0;
        for (int num : nums) {
            sum = sum + num;
        }
        int len = nums.length;
        if (sum % 2 != 0) return false;
        //先取中间值
        int target = sum / 2;
        boolean[][] dp = new boolean[len][target + 1];
        //baseCase
        dp[0][0] = true;
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                //防止下标越界
                if (nums[i] <= j){
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
            // 由于状态转移方程的特殊性，提前结束，可以认为是剪枝操作
            if (dp[i][target]) {
                return true;
            }
        }
        return dp[len - 1][target];
    }

}
