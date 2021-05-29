package algorithm.leetcode.dynamic;

import java.util.ArrayList;
import java.util.LinkedList;
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
        LinkedList<String> list0 = new LinkedList<String>();
        list0.add("");
        if (n < 1) {
            return list0;
        }
        List<List<String>> result = new ArrayList<>();
        result.add(list0);
        List<String> list1 = new ArrayList<>();
        list1.add("()");
        result.add(list1);
        //"(" + 【i=p时所有括号的排列组合】 + ")" + 【i=q时所有括号的排列组合】
        for (int i = 2; i <= n; i++) {
            LinkedList<String> temp = new LinkedList<String>();
            for (int j = 0; j < i; j++) {
                //假设
                List<String> leftRes = result.get(j);

                List<String> rightRes = result.get(i - j -1);

                //其中为左边的可能排列的情况  也就是上面的p
                for (String left : leftRes) {
                    //右边可能出现的字符串  也就是上面的q
                    for (String right :  rightRes) {
                        String el = "(" + left + ")" + right;
                        temp.add(el);
                    }
                }
            }
            //temp为所有可能出现的字符串
            result.add(temp);
        }
        return result.get(n);
    }

}
