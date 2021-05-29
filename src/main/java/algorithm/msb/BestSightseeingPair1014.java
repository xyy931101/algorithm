package algorithm.msb;

/**
 * 1014. 最佳观光组合
 * @author xiongyayun
 * @date 2021/5/9 11:31
 */
public class BestSightseeingPair1014 {

    public int maxScoreSightseeingPair(int[] values) {
        int ans = 0, mx = values[0] + 0;

        for (int i = 1; i < values.length; i++) {
            ans = Math.max(ans, mx + values[i] - i);
            mx = Math.max(mx, values[i] + i);
        }
        return ans;
    }
}
