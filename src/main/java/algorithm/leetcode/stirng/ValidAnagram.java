package algorithm.leetcode.stirng;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * @Author: Xiongyy
 * @Date: 2021/4/4 10:57
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        //如果两个字符串长度不相等就没必要继续比较了
        if (s.length() != t.length()) {
            return false;
        }
        int[] alpha = new int[26];
        //遍历两个字符串,s所有字符++,t所有字符--
        for (int i = 0; i < s.length(); i++) {
            alpha[s.charAt(i) - 'a']++;
            alpha[t.charAt(i) - 'a']--;
        }
        //只要存在不为0的字符,就可以认为不是字母异位词
        for (int i = 0; i < alpha.length; i++) {
            if (alpha[i] != 0) {
                return false;
            }
        }
        return true;
    }

}
