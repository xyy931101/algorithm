package algorithm.leetcode.array;

/**
 * 299. 猜数字游戏
 * @author: xiongyayun
 * @date: 2021/11/8 19:38
 */
public class BullsAndCows299 {

    public String getHint(String secret, String guess) {
        int n = secret.length();
        //因为是纯数字,所以只要10个就行了
        int[] cnt1 = new int[10], cnt2 = new int[10];
        int bCount = 0;
        for (int i = 0; i < n; i++) {
            char sCh = secret.charAt(i);
            char gCh = guess.charAt(i);
            if (sCh == gCh) {
                bCount++;
            }else {
                cnt1[sCh - '0']++;
                cnt2[gCh - '0']++;
            }
        }
        //奶牛的数量
        int cCount = 0;
        for (int i = 0; i < 10; i++) {
            cCount += Math.min(cnt1[i], cnt2[i]);
        }
        return bCount + "A" + cCount + "B";
    }
}
