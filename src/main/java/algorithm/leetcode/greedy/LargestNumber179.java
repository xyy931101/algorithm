package algorithm.leetcode.greedy;

import java.util.Arrays;

/**
 * 179. 最大数
 * @author: xiongyayun
 * @date: 2021/12/14 20:32
 */
public class LargestNumber179 {

    public String largestNumber(int[] nums) {
        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            str[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(str, (a, b) -> {
            String sa = a + b, sb = b + a ;
            return sb.compareTo(sa);
        });
        //如果排序后的第一个元素是0，那后面的元素肯定小于或等于0，则可直接返回0
        if(str[0].equals("0")){
            return "0";
        }
        StringBuffer sb = new StringBuffer();
        for (String s : str) {
            sb.append(s);
        }
        return sb.toString();
    }
}
