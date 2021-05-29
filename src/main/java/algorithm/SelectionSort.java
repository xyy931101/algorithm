package algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 选择排序
 * @Author: Xiongyy
 * @Date: 2021/1/10 22:17
 * .............................................
 * 佛祖保佑             永无BUG
 *
 */
public class SelectionSort {



    public static void main(String[] args) {

        int [] arr = new int[]{5, 3, 6, 8, 9, 4, 1, 2, 7};


        for (int i = 0; i < arr.length - 1 ; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
           swap(arr, i, minIndex);
        }

        for (int a: arr) {
            System.out.print(a + " ");
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
