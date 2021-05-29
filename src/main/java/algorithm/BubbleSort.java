package algorithm;

/**
 * 冒泡排序
 * @Author: Xiongyy
 * @Date: 2021/1/10 22:56
 * .............................................
 * 佛祖保佑             永无BUG
 *
 */
public class BubbleSort {
    public static void main(String[] args) {
        int [] arr = new int[]{5, 3, 6, 8, 9, 4, 1, 2, 7};

        for (int i = 0; i < arr.length -1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i] > arr[j]){
                    swap(arr, i, j);
                }
            }
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
