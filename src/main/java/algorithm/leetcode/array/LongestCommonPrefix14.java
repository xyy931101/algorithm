package algorithm.leetcode.array;

import java.util.List;

/**
 * 14. 最长公共前缀
 * @author: xiongyayun
 * @date: 2021/8/20 10:30 下午
 */
public class LongestCommonPrefix14 {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{
                "flower","flow","flight"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 1){
            return strs[0];
        }
        int length = strs[0].length();
        int count = strs.length;
        for(int i = 0; i < length; i++){
            char c = strs[0].charAt(i);
            for(int j = 1; j < count; j++){
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
