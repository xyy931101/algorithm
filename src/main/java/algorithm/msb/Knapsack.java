package algorithm.msb;

/**
 *
 * @author xiongyayun
 * @date 2021/5/11 21:39
 */
public class Knapsack {


    // 所有的货，重量和价值，都在w和v数组里
    // 为了方便，其中没有负数
    // bag背包容量，不能超过这个载重
    // 返回：不超重的情况下，能够得到的最大价值
    public static int maxValue(int[] w, int[] v, int bag) {
        if (w == null || v == null || w.length != v.length || w.length == 0) {
            return 0;
        }
        //货物的数量
        int N = w.length;
        int[][] dp  = new int[N + 1][bag + 1];

        //遍历货物
        for (int index = N - 1; index >= 0; index--) {
            //根据当前背包的剩余容量,求最大值
            for (int rest = 0; rest <= bag; rest++) {
                //不取当前货物的价值
                int p1 = dp[index + 1][rest];
                int p2 = 0;
                //取当前货物的最大价值
                int next = rest - w[index] < 0 ? -1 : dp[index + 1][rest - w[index]];
                //如果当前货物超过了背包的剩余容量·
                if (next != -1) {
                    p2 = v[index] + next;
                }
                dp[index][rest] = Math.max(p1, p2);
            }
        }
        return dp[0][bag];
    }

}
