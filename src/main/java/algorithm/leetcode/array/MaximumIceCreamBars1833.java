package algorithm.leetcode.array;

import java.util.Arrays;

/**
 * @author: xiongyayun
 * @date: 2021/7/2 8:42
 */
public class MaximumIceCreamBars1833 {

    public static void main(String[] args) {
        System.out.println(maxIceCream(new int[] {1,3,2,4,1}, 7));
    }

    public static int maxIceCream(int[] costs, int coins) {
        if(costs == null || costs.length == 0) {
            return 0;
        }
        Arrays.sort(costs);
        int count = 0;
        int index = 0;
        while(costs[index] <= coins) {
            coins = coins - costs[index];
            count++;
            index ++;
        }
        return count;
    }
}
