package algorithm.leetcode.array;

import com.alibaba.fastjson.JSONObject;

/**
 * 在未排序的数组中找到第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素
 * @Author: Xiongyy
 * @Date: 2021/3/14 16:03
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class FindKthLargest {

    public static int[] nums = new int[]{3,2,3,1,2,4,5,5,6,7,7,8,2,3,1,1,1,10,11,5,6,2,4,7,8,5,6};

    public static void main(String[] args) {
        int kthLargest = findKthLargest(nums, 2);
        System.out.println(kthLargest);
    }

    public static int findKthLargest(int[] nums, int k) {

        return getKth(k, nums, 0, nums.length - 1);
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
