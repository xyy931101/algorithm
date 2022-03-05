package algorithm.leetcode.array;

/**
 * 55. 跳跃游戏
 * @author: xiongyayun
 * @date: 2022/3/3 9:31 下午
 */
public class JumpGame55 {

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2,3,1,1,4}));
    }

    public static boolean canJump(int[] nums) {
        int nextMax = 0;
        for(int i = 0; i < nums.length; i++){
            if(nextMax < i){
                return false;
            }
            nextMax = Math.max(nums[i] +i, nextMax);
        }
        return true;
    }
}
