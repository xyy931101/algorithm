package algorithm.swordFingerOffer;

/**
 * 剑指 Offer 46. 把数字翻译成字符串
 * @author: xiongyayun
 * @date: 2022/4/7 10:30 下午
 */
public class BaShuZiFanYiChengZiFuChuanLcof_46 {

    public static void main(String[] args) {
        System.out.println(translateNum(12258));
    }

    public static int translateNum(int num) {
        String s = String.valueOf(num);
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i < s.length(); i++) {
            dp[i + 1] = dp[i];
            if(s.charAt(i - 1) != '0' && (((s.charAt(i - 1) - '0') * 10) + s.charAt(i) - '0') < 26) {
                dp[i + 1] += dp[i - 1];
            }
        }
        return dp[len];
    }

}
