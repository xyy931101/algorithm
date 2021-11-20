package algorithm.swordFingerOffer.ii;

/**
 * 剑指 Offer II 001. 整数除法
 * @author: xiongyayun
 * @date: 2021/11/20 2:24 下午
 */
public class Xoh6Oh001 {

    public int divide(int a, int b) {
        int flag=1;
        long x=a,y=b;
        if (x < 0){
            x = -x;
            flag = -flag;
        }
        if (y < 0) {
            y = -y;
            flag = -flag;
        }
        long res=0;
        long weight;
        while (x > y) {
            weight = 1;
            long tmp = y;
            while (tmp+tmp<=x){
                weight+=weight;
                tmp += tmp;
            }
            x-=tmp;
            res += weight;
        }
        return res > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int)res;
    }
}
