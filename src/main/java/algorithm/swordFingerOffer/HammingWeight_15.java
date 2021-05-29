package algorithm.swordFingerOffer;

/**
 * @Author: Xiongyy
 * @Date: 2021/2/16 20:15
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class HammingWeight_15 {

    public static void main(String[] args) {
        System.out.println(hammingWeight(1));
        System.out.println(hammingWeight(8));
        double a = 1e-6;
        System.out.println(a);
    }

    public static int hammingWeight(int n) {
        int result = 0;
        while (n != 0){
            n = n & (n -1);
            result++;
        }
        return result;
    }
}
