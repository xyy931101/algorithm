package algorithm.my;

import com.alibaba.fastjson.JSONObject;

/**
 * @author xiongyayun
 * @date 2021/5/12 22:56
 */
public class MySort {

    public static void main(String[] args) {
        System.out.println(JSONObject.toJSONString(MySort(new int[]{3,2,4,6,7,9,1})));
    }

    public static int[] MySort (int[] arr) {
        // write code here
        if(arr == null || arr.length <= 1){
            return arr;
        }
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    public static void quickSort(int []arr, int start, int end) {
        if(start >= end) {
            return;
        }
        int left = start, right = end;
        int pivot = arr[right];
        while (left < right){
            while (left < right && arr[left] <= pivot) {
                left ++;
            }
            arr[right] = arr[left];
            while (left < right && arr[right] >= pivot) {
                right --;
            }
            arr[left] = arr[right];
        }
        arr[right] = pivot;
        quickSort(arr, start, right - 1);
        quickSort(arr, right + 1, end);
    }
}
