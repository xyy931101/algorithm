package algorithm.swordFingerOffer;

/**
 * @author: xiongyayun
 * @date: 2021/7/17 16:25
 */
public class ShuZuZhongShuZiChuXianDeCiShuLcof56 {

    public int[] singleNumbers(int[] nums) {
        int eor = 0;
        for(int num : nums){
            eor ^= num;
        }

        int eor2 = eor & (-eor);

        int x = 0;

        for (int num : nums) {
            if ((num & eor2) != 0)
                x = x ^ num;
        }
        return new int[] {x, eor ^ x};
    }
}
