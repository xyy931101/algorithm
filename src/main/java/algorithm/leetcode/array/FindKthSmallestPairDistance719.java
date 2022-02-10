package algorithm.leetcode.array;

import java.util.Arrays;

/**
 * 719. 找出第 k 小的距离对
 * @author: xiongyayun
 * @date: 2022/2/10 8:46 下午
 */
public class FindKthSmallestPairDistance719 {

    public static void main(String[] args) {
        System.out.println(smallestDistancePair(new int[]{1, 6, 1}, 3));
    }

    public static int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int left = 0, right = nums[n - 1];
        int ans = 0;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            int cnt = 0;
            for (int i = 0, j = 0; i < n; i++) {
                while (j < n && nums[i] + mid >= nums[j])
                    j++;
                cnt += j - i - 1;
            }
            if (cnt < k) {
                left = mid + 1;
            }else {
                right = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }

}
