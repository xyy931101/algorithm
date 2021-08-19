package algorithm.leetcode.array;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 *
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 * @author: xiongyayun
 * @date: 2021/8/3 8:20
 */
public class ShortestUnsortedContinuousSubarray581 {

    public int findUnsortedSubarray1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int N = nums.length;
        int[] copyOf = Arrays.copyOf(nums, N);
        Arrays.sort(copyOf);
        int left = 0;
        while (left < N) {
            if (copyOf[left] != nums[left]) break;;
            left++;
        }
        if (left == N) return N;
        int right = N -1;
        while (right >= 0) {
            if (copyOf[right] != nums[right]) break;;
            right--;
        }
        return right - left + 1;
    }

    //最优解
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int N = nums.length;
        int left = nums[0];
        int right = nums[N - 1];

        for (int i = 1; i < N; i++) {

        }
        return 0;
    }
}
