package algorithm.swordFingerOffer;

/**
 * @Author: Xiongyy
 * @Date: 2021/4/20 21:04
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class MoreThanHalfNum39 {

    public int majorityElement(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }

        int votes = 0, x = 0;

        for (int num : nums) {
            if (votes == 0) {
                x = num;
            }
           if (num == x) {
               votes ++;
           }else {
               votes --;
           }
        }
        int count = 0;
        for (int num : nums) {
            if (num == x) {
                count ++;
            }
        }

        return count > nums.length / 2 ? x : 0;


    }
}
