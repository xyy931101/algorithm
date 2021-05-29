package algorithm.leetcode.array;

/**
 * @Author: Xiongyy
 * @Date: 2021/3/9 23:03
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class FindMedianSortedArrays {

    public static void main(String[] args) {
        int[]nums1 = {1,2}, nums2 = {3,4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null){
            return 0.0;
        }
        int s1 = 0, s2 = 0,i = 0;
        int l1 = nums1.length;
        int l2 = nums2.length;
        int sl = l2 + l1;
        int[] sum = new int[sl];
        while (s1 < l1 && s2 < l2){
            if(nums1[s1] < nums2[s2]){
                sum[i] = nums1[s1];
                s1++;
            }else {
                sum[i] = nums2[s2];
                s2++;
            }
            i++;
        }
        for (int j = s1; j < l1; j++) {
            sum[i] = nums1[j];
            i++;
        }
        for (int j = s2; j < l2; j++) {
            sum[i] = nums2[j];
            i++;
        }
        if(sum.length % 2 == 0){
            return (sum[sl/2 -1] + sum[sl/2]) /2.0;
        }else{
            return sum[sl/2];
        }
    }
}
