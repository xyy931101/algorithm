package algorithm.leetcode.dynamic;

/**
 * 560. 和为K的子数组
 * @author: xiongyayun
 * @date: 2021/6/11 8:41
 */
public class SubarraySumEqualsK560 {

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1,1,1}, 2));
    }

    public static int subarraySum(int[] nums, int k) {

        int n = nums.length;
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        int count = 0;
        for (int right = 1; right <= n; right++) {
            for (int left = 0; left < right; left++) {
                if (preSum[right] - preSum[left] == k) count++;
            }
        }
        return count;
    }

}
