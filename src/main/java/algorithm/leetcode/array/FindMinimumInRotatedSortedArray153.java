package algorithm.leetcode.array;

/**
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。
 * 例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
 * 若旋转 4 次，则可以得到 [0,1,2,4,5,6,7]
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 * 给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。
 * 请你找出并返回数组中的 最小元素 。
 * @Author: Xiongyy
 * @Date: 2021/4/8 8:28
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class FindMinimumInRotatedSortedArray153 {


    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray153 s = new FindMinimumInRotatedSortedArray153();
        System.out.println(s.findMin(new int[]{4,5,6,7,0,1,2}));
    }

    public int findMin(int[] nums) {
        //处理边界值
        if (nums == null || nums.length  == 0) {
            return 0;
        }
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            /* 地板除，mid更靠近left */
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            }else if (nums[mid] < nums[right]) {
                //因为中值 < 右值，中值也可能是最小值，右边界只能取到mid处
                right = mid;
            }
        }
        // 循环结束，left == right，最小值输出nums[left]或nums[right]均可
        return nums[left];
    }

}
