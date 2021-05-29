package algorithm.leetcode.array;

import com.alibaba.fastjson.JSONObject;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * @Author: Xiongyy
 * @Date: 2021/2/17 21:17
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class Rotate {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        Solution(nums, 2);
        System.out.println(JSONObject.toJSONString(nums));
    }

    public static void Solution(int[] nums, int k){
        k = k % nums.length;
        reverse(nums, 0, nums.length -1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length -1);
    }

    /**
     * 反转数组的start-end区间
     * @param nums
     * @param start
     * @param end
     */
    public static void reverse(int[] nums, int start, int end){
        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end] ;
            nums[end] = temp;

            start++;
            end--;
        }
    }
}
