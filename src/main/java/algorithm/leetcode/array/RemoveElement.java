package algorithm.leetcode.array;

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * @Author: Xiongyy
 * @Date: 2021/3/7 23:24
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n){
            if(nums[i] == val){
                nums[i] = nums[n - 1];
                n --;
            }else {
                i ++ ;
            }
        }
        return i;
    }

}
