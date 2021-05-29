package algorithm.swordFingerOffer;

/**
 * @Author: Xiongyy
 * @Date: 2021/2/16 9:13
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class CuttingRope_14_1 {

    public int cuttingRope(int n) {
        if(n == 2) {
            return 1;
        }
        if(n == 3){
            return 2;
        }
        //防止溢出
        int mod = (int)1e9 + 7;
        long res = 1;
        //当n大于4的时候才需要剪因为4剪最大值跟不剪都是4,所以没有必要
        while(n > 4) {
            res *= 3;
            //防止溢出
            res %= mod;
            n -= 3;
        }
        //这里的n是已经剪好之后的了
        return (int)(res * n % mod);
    }
}
