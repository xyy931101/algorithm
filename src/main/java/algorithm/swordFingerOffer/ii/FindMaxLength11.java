package algorithm.swordFingerOffer.ii;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer II 011. 0 和 1 个数相同的子数组
 * @author: xiongyayun
 * @date: 2022/12/10 13:46
 */
public class FindMaxLength11 {

    public static void main(String[] args) {
        System.out.println(findMaxLength(new int[]{0,0,1,0,0,0,1,1}));
    }

    public static int findMaxLength(int[] nums) {
        int res = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1) sum++;
            else sum--;
            if(map.containsKey(sum)) res = Math.max(i - map.get(sum), res);
            else map.put(sum, i);
        }
        return res;
    }
}
