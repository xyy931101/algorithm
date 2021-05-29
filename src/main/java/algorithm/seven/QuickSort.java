package algorithm.seven;

import com.alibaba.fastjson.JSONObject;
import com.examplexyy.demo.algorithm.MathUtil;

import java.util.Arrays;

/**
 * 快速排序的
 * @Author: Xiongyy
 * @Date: 2021/3/1 23:11
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] nums = MathUtil.generateRandomArray(100, 100);
//        int[] nums = new int[]{87,38,88,69,4,81,45,49,65,23};
//        int[] nums = new int[]{38,69,87,81,45,49,65,88};
        int[] copyOf = Arrays.copyOf(nums, nums.length);
        System.out.println(JSONObject.toJSONString(nums));
        quickSort(nums);
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

    public static int[] quickSort(int[] nums) {
        quickSelect(nums, 0, nums.length - 1);
        return nums;
    }

    private static void quickSelect(int[] nums, int leftIndex, int rightIndex) {
        //如果左下标比右下标小,证明已经排序完了,直接返回
        if(leftIndex >= rightIndex){
            return;
        }

        //找到比中轴pivot大和小的数，然后做交换
        int left = leftIndex, right = rightIndex, pivot = nums[leftIndex];
        while (left < right){
            //从右往左找，先找到比pivot小的数
            while(left < right && nums[right] >= pivot) {
                right--;
            }
            //把右边找到的第一个比pivot小的数赋值给pivot之前在数组的位置,并且把left的位置往前移一位
            if(left < right){
                nums[left++] = nums[right];
            }
            // 从左向右找第一个大于等于x的数
            while(left < right && nums[left] < pivot) {
                left++;
            }
            //把左边找到的第一个比pivot小的数赋值给之前第一个比pivot大的数,并且把右边节点的位置往前移动
            if(left < right){
                nums[right--] = nums[left];
            }
        }
        nums[left] = pivot;
        // 递归调用
        quickSelect(nums, leftIndex, left- 1);
        quickSelect(nums, left + 1, rightIndex);

    }
}
