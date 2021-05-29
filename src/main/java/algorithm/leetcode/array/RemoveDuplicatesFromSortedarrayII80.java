package algorithm.leetcode.array;

/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * @Author: Xiongyy
 * @Date: 2021/4/6 7:54
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class RemoveDuplicatesFromSortedarrayII80 {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        int slow = 2, fast = 2;

        while (fast < nums.length) {
            //如果
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast ++;
        }
        return slow;
    }

}
