package algorithm;

/**
 * @Author: Xiongyy
 * @Date: 2021/1/10 23:02
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class InsertionSort {

    public static void main(String[] args) {


        int [] array = new int[]{5, 3, 6, 8, 9, 4, 1, 7, 2};

        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j -1]) {
//                    swap(array, j -1, j);
                    int temp = array[j];
                    array[j] = array[j -1];
                    array[j - 1] = temp;
                }
            }
        }
        for (int a: array) {
            System.out.print(a + " ");
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
