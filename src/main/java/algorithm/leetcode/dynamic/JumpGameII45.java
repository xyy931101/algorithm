package algorithm.leetcode.dynamic;

/**
 * @author: xiongyayun
 * @date: 2022/1/16 14:16
 */
public class JumpGameII45 {

    public static void main(String[] args) {
        System.out.println(jump(new int[]{2,3,1,1,4}));
    }

    public static int jump(int[] nums) {
        int curMax = 0, nextMax = 0, steps = 0;
        for(int i = 0; i < nums.length; i++){
            nextMax = Math.max(nextMax, i + nums[i]);
            if(i == curMax){
                steps++;
                curMax = nextMax;
            }
        }
        return steps;
    }
}
