package algorithm.leetcode.array;

/**
 * 在未排序的数组中找到第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素
 * @Author: Xiongyy
 * @Date: 2021/3/14 16:03
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class FindKthLargest {

    public static int[] nums = new int[]{5,2,4,1,3,6,0};

    public static void main(String[] args) {
        int kthLargest = findKthLargest(nums, 4);
        System.out.println(kthLargest);
    }

    public static int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        return quickSort(nums, n - k, 0, n - 1);
    }

    public static int quickSort(int[] nums, int index, int start, int end){
        int left = start, right = end;
        int pivot = nums[end];
        while(left < right){
            while(left < right && nums[left] <= pivot) left++;
            nums[right--] = nums[left];
            while(left < right && nums[right] >= pivot) right--;
            nums[left] = nums[right];
        }
        nums[left] = pivot;
        if(left == index) return nums[left];
        else if(left < index) return quickSort(nums, index, left + 1, end);
        else return quickSort(nums, index, start, left - 1);
    }

}
