package algorithm.leetcode.stirng;

import java.util.*;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * @Author: Xiongyy
 * @Date: 2021/4/3 10:36
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class ValidParentheses20 {

    public static void main(String[] args) {
        ValidParentheses20 validParentheses20 = new ValidParentheses20();
        validParentheses20.isValid("()");
    }

    Map<Character, Character> pairs = new HashMap<Character, Character>() {{
        put(')', '(');
        put(']', '[');
        put('}', '{');
    }};

    public boolean isValid(String s) {
        //处理边界值
        if (s == null || s.length() < 2 || s.length() % 2 == 1) {
            return false;
        }
        //构建双端队列
        Deque<Character> deque = new LinkedList<Character>();

        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);

            if (pairs.containsKey(charAt)) {
                //这里需不需要判断是否包含?
                if (deque.isEmpty() || !deque.peek().equals(pairs.get(charAt))) {
                    return false;
                }
                deque.pop();
            }else {
                deque.push(charAt);
            }
        }
        return deque.isEmpty();
    }
}
