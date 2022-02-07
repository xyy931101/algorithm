package algorithm.swordFingerOffer;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 找出数组中重复的数字。
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，
 * 但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字
 * @Author: Xiongyy
 * @Date: 2021/2/14 9:42
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class FindRepeatNumber_3 {

    public static void main(String[] args) {
        System.out.println(findRepeatNumber(new int[]{2, 2, 1, 0, 4, 5, 3}));
    }

    public static int findRepeatNumber(int[] nums) {
        //用于存放数组中每个数字的重复次数
        Deque deque = new LinkedList();
        int i = 0;
        while(i < nums.length) {
            if(nums[i] == i) {
                i++;
                continue;
            }
            if(nums[nums[i]] == nums[i]) return nums[i];
            int tmp = nums[i];
            nums[i] = nums[tmp];
            nums[tmp] = tmp;
        }
        return -1;

    }
}
