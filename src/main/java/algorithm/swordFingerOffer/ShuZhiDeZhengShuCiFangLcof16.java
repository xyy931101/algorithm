package algorithm.swordFingerOffer;

/**
 * 剑指 Offer 16. 数值的整数次方
 * @Author: Xiongyy
 * @Date: 2021/4/15 22:45
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class ShuZhiDeZhengShuCiFangLcof16 {

    public static void main(String[] args) {
        System.out.println(myPow(8.84372,-5));
    }

    public static double myPow(double x, int n) {
        double result = 1.0;
        if (n == 0) {
            return 1.0;
        }
        long b = n;
        double res = 1.0;
        int pow = Math.abs(n);
        while(pow > 0) {
            if((pow & 1) == 1) {
                res *= x;
            }
            x *= x;
            pow >>= 1;
        }
        if (n < 0) {
            res = 1 / res;
        }
        return res;
    }
}
