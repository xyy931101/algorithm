package algorithm.leetcode.array;

/**
 * 287. 寻找重复数
 * @author: xiongyayun
 * @date: 2022/3/3 9:24 下午
 */
public class FindTheDuplicateNumber287 {

    public int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[nums[0]];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        slow = 0;
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

}
