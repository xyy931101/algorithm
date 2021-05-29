package algorithm.leetcode.array;

/**
 * 1738. 找出第 K 大的异或坐标值
 * @author xiongyayun
 * @date 2021/5/19 21:11
 */
public class FindKthLargestXorCoordinateValue1738 {

    public static int kthLargestValue(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] pre = new int[m + 1][n + 1];
        int[] xorRes = new int[m * n];
        int xorResIndex = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                pre[i][j] = pre[i - 1][j - 1] ^ pre[i][j - 1] ^ pre[i - 1][j] ^ matrix[i - 1][j - 1];
                xorRes[xorResIndex++] = pre[i][j];
            }
        }
        return getKth(k, xorRes, 0, xorRes.length);
    }

    public static int getKth(int k, int[] nums, int start, int end) {
        if(start >= end){
            return nums[end];
        }

        int pivot = nums[start];

        int left = start;
        int right = end;

        while (left < right) {

            while (left < right && nums[right] >= pivot) {
                right--;
            }

            if (left < right){
                nums[left] = nums[right];
            }
            while (left < right && nums [left] < pivot) {
                left++;
            }
            if(left < right) {
                nums[right] = nums[left];
            }

        }
        nums[left] = pivot;
        if ( k == nums.length - left ) {
            return pivot;
        } else if (nums.length - left < k) {
            return  getKth(k, nums, start, left - 1);
        } else {
            return getKth(k, nums, left + 1, end);
        }
    }
}
