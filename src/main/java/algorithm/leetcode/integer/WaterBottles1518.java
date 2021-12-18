package algorithm.leetcode.integer;

/**
 * 1518. 换酒问题
 * @author: xiongyayun
 * @date: 2021/12/17 11:47 下午
 */
public class WaterBottles1518 {

    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles;
        while (numBottles >= numExchange) {
            //能加多少
            int a = numBottles / numExchange;
            //还剩余多少
            int b = numBottles % numExchange;
            ans += a;
            numBottles = a + b;
        }
        return ans;
    }

}
