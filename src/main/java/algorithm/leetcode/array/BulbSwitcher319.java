package algorithm.leetcode.array;

/**
 * 319. 灯泡开关
 * @author: xiongyayun
 * @date: 2021/11/15 8:29
 */
public class BulbSwitcher319 {

    public int bulbSwitch(int n) {
        if (n <= 1) return n;

        return (int)Math.sqrt(n);
    }
}
