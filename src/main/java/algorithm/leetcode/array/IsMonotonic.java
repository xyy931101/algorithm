package algorithm.leetcode.array;

/**
 * 如果数组是单调递增或单调递减的，那么它是单调的。
 *
 * 如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。
 *
 * 当给定的数组 A 是单调数组时返回 true，否则返回 false。
 * @Author: Xiongyy
 * @Date: 2021/2/28 23:48
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class IsMonotonic {

    public static void main(String[] args) {
        IsMonotonic a = new IsMonotonic();
        System.out.println(a.isMonotonic(new int[]{6,5,4,4}));
    }

    public boolean isMonotonic(int[] A) {
        boolean inc = true, dec = true;
        int n = A.length;
        for (int i = 0; i < n - 1; ++i) {
            if (A[i] > A[i + 1]) {
                inc = false;
            }
            if (A[i] < A[i + 1]) {
                dec = false;
            }
        }
        return inc || dec;
    }
}
