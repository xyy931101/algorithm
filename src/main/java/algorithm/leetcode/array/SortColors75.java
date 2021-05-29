package algorithm.leetcode.array;

/**
 * @author xiongyayun
 * @date 2021/5/20 23:37
 */
public class SortColors75 {

    public void sortColors(int[] nums) {
        if (nums == null || nums.length < 2) return;
        int len = nums.length;
        int zero = -1, two = len - 1,  i = 0;

        while (i <= two) {
            if (nums[i] == 0) {
                zero++;
                swap(nums, i, zero);
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                swap(nums, i, two);
                two--;
            }
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
