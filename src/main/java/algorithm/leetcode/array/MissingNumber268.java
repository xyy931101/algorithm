package algorithm.leetcode.array;

import java.util.Arrays;

/**
 * 268. 丢失的数字
 * @author: xiongyayun
 * @date: 2021/11/6 12:04
 */
public class MissingNumber268 {

    public int missingNumber(int[] nums) {
        Arrays.sort(nums);

        int ans = 0;
        for (int num :nums) {
            if (num != ans) {
                break;
            }
            ans++;
        }
        return ans;
    }

    public int missingNumber2(int[] nums) {
        int n = nums.length;
        int cur = 0, sum = n * (n + 1) / 2;
        for (int i : nums) cur += i;
        return sum - cur;
    }
}
