package algorithm.leetcode.stirng;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 有效括号字符串为空 ("")、"(" + A + ")" 或 A + B，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。
 * 例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。
 *
 * 如果有效字符串 S 非空，且不存在将其拆分为 S = A+B 的方法，我们称其为原语（primitive），
 * 其中 A 和 B 都是非空有效括号字符串。
 *
 * 给出一个非空有效字符串 S，考虑将其进行原语化分解，使得：S = P_1 + P_2 + ... + P_k，
 * 其中 P_i 是有效括号字符串原语。
 *
 * 对 S 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S 。
 * @Author: Xiongyy
 * @Date: 2021/4/10 11:55
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class RemoveOutermostParentheses {

    public String removeOuterParentheses(String S) {
        if(S == null || S.length() < 2){
            return null;
        }
        Deque stack = new LinkedList();
        StringBuffer buffer = new StringBuffer();

        for (char c :  S.toCharArray()) {
            if (stack.isEmpty() && c == '(') {
                stack.push(c);
            }else if (!stack.isEmpty() && c == '(') {
                stack.push(c);
                buffer.append(c);
            }
            if (c == ')') {
                stack.pop();
                //为空的话,则证明是最外层,需要剥除
                if (!stack.isEmpty()) {
                    //如果这个时候不为空,则添加至字符串
                    buffer.append(c);
                }
            }
        }
        return buffer.toString();
    }


}
