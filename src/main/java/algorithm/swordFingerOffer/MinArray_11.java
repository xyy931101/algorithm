package algorithm.swordFingerOffer;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组[3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 * @Author: Xiongyy
 * @Date: 2021/2/14 22:31
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class MinArray_11 {

    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 1, 1};
        int[] arr2 = {5, 4, 3, 1, 2};
        System.out.println(minArray(arr));
        System.out.println(minArray(arr2));
    }

    public static int minArray(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (numbers[pivot] < numbers[high]) {
                high = pivot;
            } else if (numbers[pivot] > numbers[high]) {
                low = pivot + 1;
            } else {
                high -= 1;
            }
        }
        return numbers[low];
    }
}
