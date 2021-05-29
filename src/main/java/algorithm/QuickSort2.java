package algorithm;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;

/**
 * @Author: Xiongyy
 * @Date: 2021/1/31 15:45
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class QuickSort2 {

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


    private static void sort(int[] nums, int leftBound, int rightBound){
        if(leftBound >= rightBound){
            return;
        }
        int pivotIndex = partition(nums, leftBound, rightBound);

        System.out.println("pivotIndex:" + pivotIndex);
        sort(nums, leftBound, pivotIndex - 1);
        sort(nums, pivotIndex + 1, rightBound);
    }

    private static int partition(int[] arr, int leftBound, int rightBound){
        int pivot = arr[rightBound];
        int left = leftBound;
        int right = rightBound;

        while (left < right){
            while (left < right && arr[left] <= pivot){
                left ++;
            }
            System.out.println("left :" + left);
            while (left < right && arr[right] >= pivot){
                right --;
            }
            System.out.println("right :" + right);
            if (left < right) {
                swap(arr, left, right);
            }
            System.out.println(JSONObject.toJSONString(arr));
        }
        System.out.println(JSONObject.toJSONString(arr));
        System.out.println("before" + JSONObject.toJSONString(arr));


        swap(arr, left, rightBound);

        System.out.println("after:" + JSONObject.toJSONString(arr));
        return left;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
