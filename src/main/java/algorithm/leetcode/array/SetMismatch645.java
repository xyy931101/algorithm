package algorithm.leetcode.array;

/**
 * @author: xiongyayun
 * @date: 2021/7/4 16:12
 */
public class SetMismatch645 {

    public int[] findErrorNums(int[] nums) {
        int[] counts = new int[nums.length + 1];

        for(int num : nums){
            counts[num]++;
        }

        int[] res = new int[2];
        for(int i = 1; i < counts.length; i++){
            if(counts[i] == 0){
                res[1] = i;
            }else if(counts[i] == 2){
                res[0] = i;
            }
        }
        return res;
    }
}
