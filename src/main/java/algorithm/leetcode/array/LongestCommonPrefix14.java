package algorithm.leetcode.array;

import java.util.List;

/**
 * 14. 最长公共前缀
 * @author: xiongyayun
 * @date: 2021/8/20 10:30 下午
 */
public class LongestCommonPrefix14 {

    public String longestCommonPrefix(String[] strs) {
        //边界值
        if (strs == null || strs.length == 0) return "";
        String ans = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String str = strs[i];
            int j=0;
            for(;j<ans.length() && j < strs[i].length();j++) {
                if (ans.charAt(j) != str.charAt(j)) break;
            }
            ans = ans.substring(0, j);
            //进行前置判断,如果没有公共前缀了就没有必要走下去了
            if (ans == "") return ans;
        }
        return ans;
    }
}
