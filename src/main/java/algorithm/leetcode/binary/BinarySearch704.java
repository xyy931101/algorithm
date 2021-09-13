package algorithm.leetcode.binary;

/**
 * @author: xiongyayun
 * @date: 2021/9/6 8:36
 */
public class BinarySearch704 {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int N = nums.length;
        if (target < nums[0] || target > nums[N - 1]) return  -1;
        int left = 0, right = N -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}
