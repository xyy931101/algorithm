package algorithm.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * @Author: Xiongyy
 * @Date: 2021/2/16 21:09
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
           if(nums[i] != nums[j]){
               nums[i + 1] = nums[j];
               i ++;
           }
        }
        return i + 1;
    }
}
