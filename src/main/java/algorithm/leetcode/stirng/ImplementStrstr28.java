package algorithm.leetcode.stirng;

/**
 * 28. 实现 strStr()
 * 实现 strStr() 函数。
 *
 * 给你两个字符串 haystack 和 needle ，
 * 请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
 * @Author: Xiongyy
 * @Date: 2021/4/20 7:59
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class ImplementStrstr28 {

    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        if (needle.length() == 0) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }

        for (int i = 0; i < haystack.length() - needle.length(); i++) {


        }

        return 0;
    }

}
