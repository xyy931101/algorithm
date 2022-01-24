package algorithm.leetcode.dynamic;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * @Author: Xiongyy
 * @Date: 2021/4/11 17:00
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class generateParentheses22 {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<String>();
        StringBuffer sb = new StringBuffer();
        dfs(res, sb, 0, 0, n);
        return res;
    }

    public static void dfs(List<String> res, StringBuffer sb, int left, int right, int max){
        if(sb.length() == max << 1){
            res.add(sb.toString());
            return;
        }
        if(left < max){
            sb.append("(");
            dfs(res, sb, left + 1, right, max);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(right < left){
            sb.append(")");
            dfs(res, sb, left, right +1, max);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
