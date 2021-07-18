package algorithm.seven.my;

import algorithm.MathUtil;
import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;

/**
 * 用来自己些的归并排序
 * @author: xiongyayun
 * @date: 2021/7/18 17:09
 */
public class MyMergeSort {

    public static void main(String[] args) {
        int[] nums = MathUtil.generateRandomArray(100, 100);
        int[] copyOf = Arrays.copyOf(nums, nums.length);
        System.out.println(JSONObject.toJSONString(nums));
        mergeSort(nums);
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

    public static void mergeSort(int[] arr) {
        //如果长度小于等于1,则没有必要进行排序
        if (arr == null || arr.length <= 1) return;;
        process(arr, 0, arr.length - 1);
    }

    public static void process(int[] arr, int L, int R) {
        if (L == R) { // base case
            return;
        }
        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    public static void merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        //先归并
        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        // 要么p1越界了，要么p2越界了
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
    }
}
