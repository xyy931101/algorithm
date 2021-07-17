package algorithm.swordFingerOffer;

/**
 * 剑指 Offer 50. 第一个只出现一次的字符
 * @author: xiongyayun
 * @date: 2021/7/17 16:45
 */
public class DiYiGeZhiChuXianYiCiDeZiFuLcof50 {

    public char firstUniqChar(String s) {
        int[] count = new int[26];
        char[] chars = s.toCharArray();

        for (char ch :  chars) {
            count[ch - 'a']++;
        }

        for (char ch :  chars) {
            if(count[ch - 'a'] == 1) return ch;
        }
        return ' ';
    }
}
