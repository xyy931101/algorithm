package algorithm.leetcode.dynamic;

/**
 * 740. 删除并获得点数
 */
public class DeleteAndEarn740 {

    public int deleteAndEarn(int[] nums) {
        //边界值判断
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        //获取数组中最大值,好做dp
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        //all数组存储着以元素值为下标,元素在nums数组中的个数为值
        int[] all = new int[max + 1];
        for (int num : nums) {
            all[num]++;
        }

        //构建DP数组
        int[] dp = new int[max + 1];
        //避免出现数组下标越界
        dp[1] = all[1] * 1;
        dp[2] = Math.max(dp[1], all[2] * 2);
        //动态规划求解
        for (int i = 2; i <= max; ++i) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + i * all[i]);
        }

        return dp[max];
    }


    //作为存储所有元素,其下标为nums中的元素的值,值为nums中的元素的个数
    int[] cnts = new int[10009];
    public int deleteAndEarn2(int[] nums) {
        int max = 0;
        for (int x : nums) {
            cnts[x]++;
            max = Math.max(max, x);
        }
        // f[i][0] 代表「不选」数值 i；f[i][1] 代表「选择」数值 i
        int[][] f = new int[max + 1][2];
        for (int i = 1; i <= max; i++) {
            f[i][1] = f[i - 1][0] + i * cnts[i];
            f[i][0] = Math.max(f[i - 1][1], f[i - 1][0]);
        }
        return Math.max(f[max][0], f[max][1]);
    }
}
