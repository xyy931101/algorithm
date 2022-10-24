package algorithm.leetcode.array;

/**
 * 915. 分割数组
 * @author: xiongyayun
 * @date: 2022/10/24 20:59
 */
public class PartitionArrayIntoDisjointIntervals915 {

    public static void main(String[] args) {
        System.out.println(partitionDisjoint(new int[]{5,0,3,8,6}));
    }

    public static int partitionDisjoint(int[] nums) {
        int len = nums.length;
        if(len <= 1) return len;
        int[] minR = new int[len];
        int min = nums[len - 1];
        for(int i = len - 1; i >= 0; i--){
            min = Math.min(min, nums[i]);
            minR[i] = min;
        }
        int maxLeft = 0;
        for(int i = 0; i < len - 1; i++){
            maxLeft = Math.max(maxLeft, nums[i]);
            if(maxLeft < minR[i + 1]) return i + 1;
        }
        return -1;
    }
}
