package algorithm.swordFingerOffer;

/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。
 * 请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，
 * 此时得到的最大乘积是18。
 * @Author: Xiongyy
 * @Date: 2021/2/15 17:30
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class CuttingRope_14 {

    public int cuttingRope(int n) {
        int[] memo = new int[n+1];
        memo[2] = 1;

        return F(memo, n);
    }

    private int F(int[] memo, int n){
        // 如果备忘录中有记录，则直接返回
        if(memo[n] != 0){
            return memo[n];
        }
        int res = 0;
        for(int i = 2; i < n; i++){
            //Math.max(i * F(memo, n-i)表示剪取了i之后继续往下剪, i *(n-1)则表示不剪了
            res = Math.max(res, Math.max(i * F(memo, n-i), i * (n-i)));
        }
        memo[n] = res;
        return memo[n];
    }

}
