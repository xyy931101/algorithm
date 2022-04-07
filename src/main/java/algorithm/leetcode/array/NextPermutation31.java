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
            int len = nums.length;
            for(int i = len - 1; i > 0; i--){
                //找到第一个从后往前是递减的数据
                if(nums[i] > nums[i - 1]){
                    //排序后面的数组数据
                    Arrays.sort(nums, i, len);
                    //找到第一个比i - 1大的数字,然后跟i - 1位置交换
                    for(int j = i; j < len; j++){
                        if(nums[j] > nums[i - 1]){
                            int temp = nums[i - 1];
                            nums[i - 1] = nums[j];
                            nums[j] = temp;
                            return;
                        }
                    }
                }
            }
            //本身就是一个递减数据,返回排序后的就行了
            Arrays.sort(nums);
        }
}
