package algorithm.swordFingerOffer;

import java.util.Arrays;

/**
 * 剑指 Offer 60. n个骰子的点数
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 *
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 * @author: xiongyayun
 * @date: 2022/4/6 10:19 下午
 */
public class NgeTouZiDeDianShuLcof_60 {

    public double[] dicesProbability(int n) {
        double[] dp = new double[6];
        Arrays.fill(dp, 1.0 / 6.0);

        for (int i = 2; i <= n; i++) {
            double[] temp = new double[5 * i + 1];
            //遍历上一轮的结果,得到这轮的结果
            for (int j = 0; j < dp.length; j++) {
                //上一轮结果依次加上1-6,得到概率
                for (int k = 1; k <= 6; k++) {
                    //因为这一轮是出现了6中情况,所以要除以6
                    temp[j + k] += dp[k] / 6.0;
                }
            }
            dp = temp;
        }
        return dp;
    }
}
