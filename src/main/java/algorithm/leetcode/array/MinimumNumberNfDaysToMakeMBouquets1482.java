package algorithm.leetcode.array;

/**
 * 1482. 制作 m 束花所需的最少天数
 * @author xiongyayun
 * @date 2021/5/9 22:33
 */
public class MinimumNumberNfDaysToMakeMBouquets1482 {

    public static void main(String[] args) {
        int i = 2;

        System.out.println(i);
    }

    public static int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if (m * k > n) return -1;

        // 最小值，最大值(作为左右边界)
        int min = bloomDay[0], max = bloomDay[0];
        for (int day : bloomDay) {
            min = Math.min(min, day);
            max = Math.max(max, day);
        }
        // 二分：
        int l = min, r = max, ans = max;
        while (l <= r) {
            // 能否在day天内制作m束花？
            int day = l + (r-l)/2;
            if (canDo(bloomDay, m, k, day)) {
                ans = day;
                r = day - 1;
            } else {
                l = day + 1;
            }
        }

        return ans;
    }

    // 能否在day天内制作m束花，连续k朵花制作一束花
    private static boolean canDo(int[] bloomDay, int m, int k, int day) {
        // 连续花朵数量
        int count = 0;
        for (int d : bloomDay) {
            if (d <= day) { // 此花已开
                count++;
                if (count == k) { // 制作1束花
                    count = 0;
                    m--;
                    if (m == 0) return true;
                }
            } else {
                count = 0;
            }
        }
        return false;
    }
}
