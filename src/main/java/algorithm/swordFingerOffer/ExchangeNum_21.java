package algorithm.swordFingerOffer;

import com.alibaba.fastjson.JSONObject;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分
 * @Author: Xiongyy
 * @Date: 2021/2/18 22:42
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class ExchangeNum_21 {

    public static void main(String[] args) {
        int[] num = {1,3,5};
        System.out.println(JSONObject.toJSONString(exchange(num)));
    }

    public static int[] exchange(int[] nums) {
        if(nums == null || nums.length <= 1){
            return nums;
        }
        int left = 0;
        int right = nums.length -1;
        while (left < right){
            while (left < right && (nums[left] & 1) == 1){
                right ++;
            }
            while (right > left && (nums[right] & 1) == 0){
                right --;
            }
            if(left < right){
                swap(nums, left, right);
            }
        }
        return nums;
    }

    private static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
