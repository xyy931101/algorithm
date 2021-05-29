package algorithm;

import java.security.SecureRandom;
import java.util.Arrays;

/**
 * @Author: Xiongyy
 * @Date: 2021/1/31 15:14
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class MathUtil {

    public static int[] generateRandomArray(int maxValue, int size){
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new SecureRandom().nextInt(maxValue);
        }
        return arr;
    }



}
