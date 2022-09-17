package algorithm.leetcode.integer;

import java.util.ArrayList;
import java.util.List;

/**
 * 670. 最大交换
 * @author: xiongyayunÓ
 * @date: 2022/9/13 22:04Ø
 */
public class MaximumSwap670 {

    public int maximumSwap(int num) {
        char[] chars = Integer.toString(num).toCharArray();
        int maxIdx = chars.length - 1;
        int[] maxArr = new int[chars.length];
        for (int i = chars.length - 1; i >= 0  ; i--) {
            if (chars[i] > chars[maxIdx]) {
                maxIdx = i;
            }
            maxArr[i] = maxIdx;
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[maxArr[i]] != chars[i]) {
                char temp = chars[maxArr[i]];
                chars[maxArr[i]] = chars[i];
                chars[i] = temp;
                break;
            }
        }
        return Integer.parseInt(new String(chars));
    }
}
