package algorithm.leetcode.array;

import java.util.Arrays;

/**
 * 31. 下一个排列
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须 原地 修改，只允许使用额外常数空间。
 * @Author: Xiongyy
 * @Date: 2021/4/8 23:06
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class NextPermutation31 {

        public void nextPermutation(int[] nums) {
            for (int i = nums.length - 1; i > 0 ; i--) {
                if (nums[i] > nums[i - 1]) {
                    Arrays.sort(nums, i, nums.length);
                    for (int j = i; j < nums.length; j++) {
                        if (nums[j] > nums[i - 1]) {
                            swap(nums, i - 1, j);
                            return;
                        }
                    }
                }
            }
            //走到这一步则证明是递增的数组
            Arrays.sort(nums);
        }

        public void swap(int[] nums, int left, int right){
            int k = nums[left];
            nums[left] = nums[right];
            nums[right] = k;
        }
}
