package algorithm.leetcode.stirng;

/**
 * 520. 检测大写字母
 * @author: xiongyayun
 * @date: 2021/11/13 10:53
 */
public class DetectCapital520 {

    public static void main(String[] args) {
        System.out.println('a' - 'A');
    }

    public boolean detectCapitalUse(String word) {
        if (word.length() == 1) return true;

        char[] chars = word.toCharArray();
        int len = chars.length;

        int charUpCount = 0, charDownCount = 0;
        for (int i = 1; i < len; i++) {
            if (chars[i] >= 'a') charDownCount++;
            else charUpCount++;
        }
        if (charDownCount == len - 1) {
            return true;
        }else if (chars[0]<='Z' && charUpCount == len - 1){
            return true;
        }else {
            return false;
        }
    }


}
