package algorithm.seven;

/**
 * 归并排序
 * @author: xiongyayun
 * @date: 2021/7/18 17:01
 */
public class MergeSort {
    // 递归方法实现
    public static void mergeSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    // arr[L...R]范围上，变成有序的
    // L...R    N    T(N) = 2*T(N/2) + O(N)  ->
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
        //再把原来的位置归位
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
    }


    // 非递归方法实现
    public static void mergeSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int N = arr.length;
        int mergeSize = 1;// 当前有序的，左组长度
        // 一组是2倍的mergeSize
        while (mergeSize < N) { // log N
            int L = 0;
            // 0....
            while (L < N) {
                // L...M  左组（mergeSize）
                int M = L + mergeSize - 1;
                if (M >= N) { // 当前组凑不齐,只有左边, 肯定有序
                    break;
                }
                //  L...M   M+1...R(mergeSize)
                // 有可能最后一组右组数目不够
                int R = Math.min(M + mergeSize, N - 1);
                merge(arr, L, M, R);
                L = R + 1; // 下一次左组
            }
            if (mergeSize > N / 2) {
                break;
            }
            mergeSize <<= 1;
        }
    }
}
