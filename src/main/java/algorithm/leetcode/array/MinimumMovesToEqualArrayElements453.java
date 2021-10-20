package algorithm.leetcode.array;

/**
 * 453. 最小操作次数使数组元素相等
 * @author: xiongyayun
 * @date: 2021/10/20 10:00 下午
 */
public class MinimumMovesToEqualArrayElements453 {

    public int minMoves(int[] nums) {
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min = nums[i] < min ? nums[i] : min;
        }
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans += nums[i] - min;
        }
        return ans;
    }
}
