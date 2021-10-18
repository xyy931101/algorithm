package algorithm.leetcode.integer;

/**
 * @author: xiongyayun
 * @date: 2021/10/18 8:11
 */
public class NumberComplement476 {

    public static void main(String[] args) {
        System.out.println(findComplement(5));
    }

    public static int findComplement(int num) {
        int div = 1, temp = 0;
        while ((num & div) != num) {
            temp = div << 1;
            div = temp ^ 1;
        }
        return div ^ num;
    }
}
