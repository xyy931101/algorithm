package algorithm.leetcode.array;

/**
 * 给定一个整数数组  nums，求出数组从索引i到（≤j）范围内元素的总和，包含i、j两点。
 *
 * 实现 NumArray 类：
 *
 * NumArray(int[] nums) 使用数组 nums 初始化对象
 * int sumRange(int i, int j) 返回数组 nums 从索引i到j（i≤j）范围内元素的总和，包含i、j点（也就是 sum(nums[i], nums[i + 1], ... , nums[j])）
 * @Author: Xiongyy
 * @Date: 2021/3/1 22:06
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class NumArray {
    int[] sums;
    public NumArray(int[] nums) {
        int i = nums.length;
        sums = new int[i + 1];
        for (int j = 0; j < i; j++) {
            sums[i + 1] = sums[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sums[j +1] - sums[i];
    }

}
