package algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * @Author: Xiongyy
 * @Date: 2021/3/7 22:49
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(" "));
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() < 1){
            return 0;
        }
        Set<Character> occ = new HashSet<Character>();
        int length = s.length();
        //每轮循环中,右指针的节点
        int right = -1, ret = 0;
        for(int i = 0; i < length; i++){
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符(主要是为了移除当前字符的前一个字符)
                occ.remove(s.charAt(i - 1));
            }
            while(right + 1 < length && !occ.contains(s.charAt(right + 1))){
                // 不断地移动右指针
                occ.add(s.charAt(right + 1));
                ++right;
            }
            //算出当前字符往后最大的无重复的字符串长度
            ret = Math.max(ret, right - i + 1);
        }
        return ret;
    }

    
}
