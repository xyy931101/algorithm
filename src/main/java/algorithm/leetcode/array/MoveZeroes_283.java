package algorithm.leetcode.array;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * @Author: Xiongyy
 * @Date: 2021/3/30 19:38
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class MoveZeroes_283 {
    public static void main(String[] args) {
        int[] num = {0,1,0,3,12};
        moveZeroes(num);

        System.out.println(num);
    }

    public static void moveZeroes(int[] nums) {
        //非0 的下标
        int j = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != 0) {
                //y为最后部不为0的位置,直接替换
                nums[j] = nums[i];
                //只有当i跟j不相等的情况,才把置为0
                if (i != j) {
                    nums[i] = 0;
                }

                j++;
            }
        }
    }

}
