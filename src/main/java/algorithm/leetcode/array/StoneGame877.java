package algorithm.leetcode.array;

/**
 * 877. 石子游戏
 * @author: xiongyayun
 * @date: 2021/6/16 8:27
 */
public class StoneGame877 {

    public boolean stoneGame(int[] piles) {
        if (piles == null || piles.length == 0) return false;
        //亚历克斯先手
        int first = first(piles, 0, piles.length - 1);
        //李后手
        int gote = gote(piles, 0, piles.length - 1);
        return first > gote;
    }

    private int gote(int[] piles, int left, int right) {
        if (left == right) {
            return 0;
        }
        int p1 = first(piles, left + 1, right);
        int p2 = first(piles, left, right - 1);

        return Math.min(p1, p2);

    }

    private int first(int[] piles, int left, int right) {
        if (left == right) {
            return piles[left];
        }

        int p1 = piles[left] + gote(piles, left + 1, right);
        int p2 = piles[right] + gote(piles, left, right - 1);

        return Math.max(p1, p2);
    }

}
