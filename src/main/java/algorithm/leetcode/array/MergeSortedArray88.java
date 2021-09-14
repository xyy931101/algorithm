package algorithm.leetcode.array;

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素。
 * @Author: Xiongyy
 * @Date: 2021/4/5 9:56
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class MergeSortedArray88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null) {
            return;
        }

        int index = nums1.length - 1;
        while (m > 0 && n > 0) {
            if (nums1[m -1] > nums2[n - 1]) {
                nums1[index--] = nums1[--m];
            }else {
                nums1[index--] = nums2[--n];
            }
        }
        while (m > 0) {
            nums1[index--] = nums1[--m];
        }
        while (n > 0) {
            nums1[index--] = nums2[--n];
        }
    }

}
