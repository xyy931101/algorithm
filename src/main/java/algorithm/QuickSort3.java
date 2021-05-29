package algorithm;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;

/**
 * @Author: Xiongyy
 * @Date: 2021/4/20 20:40
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class QuickSort3 {

    public static void main(String[] args) {
        int[] nums = MathUtil.generateRandomArray(100, 100);
//        int[] nums = new int[]{87,38,88,69,4,81,45,49,65,23};
//        int[] nums = new int[]{38,69,87,81,45,49,65,88};
        int[] copyOf = Arrays.copyOf(nums, nums.length);
        System.out.println(JSONObject.toJSONString(nums));
        sort(nums,0, nums.length - 1);
        System.out.println(JSONObject.toJSONString(nums));
        Arrays.sort(copyOf);

        for (int i = 0; i < nums.length; i++) {
            if (copyOf[i] != nums[i]){
                System.out.println("fuck.....");
                break;
            }
        }

        System.out.println("nice!!!!!");
    }

    public static void sort(int[] nums, int start, int end){
        if (start >= end) {
            return;
        }
        int temp = nums[end], left = start, right = end;

        while (left < right) {

            while (left < right && nums[left] <= temp) {
                left++;
            }
            nums[right] = nums[left];

            while (left < right && nums[right] >= temp) {
                right--;
            }
            nums[left] = nums[right];
        }
        nums[left] = temp;
        sort(nums, start, left - 1);
        sort(nums, left + 1, end);
    }

}
