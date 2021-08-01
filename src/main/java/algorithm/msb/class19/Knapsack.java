package algorithm.msb.class19;

/**
 * 给定两个长度都为N的数组weights和values，
 * weights[i]和values[i]分别代表 i号物品的重量和价值。
 * 给定一个正数bag，表示一个载重bag的袋子，
 * 你装的物品不能超过这个重量。
 * 返回你能装下最多的价值是多少?
 *
 * @author: xiongyayun
 * @date: 2021/8/1 9:22 下午
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
        // 尝试函数！
        return process(w, v, 0, bag);
    }

    // index 0~N 第几号货物
    // rest 背包还剩多少容量
    private static int process(int[] w, int[] v, int index, int rest) {
        if (rest < 0) {
            return -1;
        } else if (index == v.length) {
            return 0;
        }
        //不要第index号货物
        int p1 = process(w, v, index + 1, rest);
        //因为这里有可能出现溢出的情况,所以要根据-1做判断
        int next = process(w, v, index + 1, rest - w[index]);
        //如果背包溢出了,就直接返回没有纳入当前货物的情况
        if (next == -1) {
            return p1;
        }
        int p2 = next + v[index];
        return Math.max(p1, p2);
    }

    public static int dp(int[] w, int[] v, int bag) {
        //便捷情况
        if (w == null || v == null || w.length != v.length || w.length == 0) {
            return 0;
        }
        int N = w.length;
        int[][] dp = new int[N + 1][bag + 1];

        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= bag; rest++) {
                int p1 = dp[index + 1][rest];
                //因为这里有可能出现溢出的情况,所以要根据-1做判断
                int p2 = 0;
                //如果背包溢出了,就直接返回没有纳入当前货物的情况
                int next = rest - w[index] < 0 ? -1 : dp[index + 1][rest - w[index]];
                if (next != -1) {
                    p2 = next + v[index];
                }
                dp[index][rest] = Math.max(p1, p2);
            }
        }
        return dp[0][bag];
    }

    public static void main(String[] args) {
        int[] weights = {3, 2, 4, 7, 3, 1, 7};
        int[] values = {5, 6, 3, 19, 12, 4, 2};
        int bag = 15;
        System.out.println(maxValue(weights, values, bag));
        System.out.println(dp(weights, values, bag));
    }
}
