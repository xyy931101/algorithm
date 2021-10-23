package algorithm.leetcode.integer;

/**
 * 492. 构造矩形
 * @author: xiongyayun
 * @date: 2021/10/23 13:06
 */
public class ConstructTheRectangle492 {

    public int[] constructRectangle(int area) {
        int w = (int) Math.sqrt(area);
        while (area % w != 0) {
            w--;
        }
        return new int[]{area / w, w};
    }

}
