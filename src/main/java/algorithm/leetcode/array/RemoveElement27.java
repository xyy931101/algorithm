package algorithm.leetcode.array;

/**
 * 27. 移除元素
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * @Author: Xiongyy
 * @Date: 2021/4/19 8:19
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class RemoveElement27 {

    public int removeElement(int[] nums, int val) {
        //边界值处理
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int i = 0, n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n-1];
                n--;
            }else {
                i ++;
            }
        }
        return i;
    }
}
