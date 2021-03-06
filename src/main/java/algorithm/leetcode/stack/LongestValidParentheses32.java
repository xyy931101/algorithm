package algorithm.leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 32. 最长有效括号
 * @author xiongyayun
 * @date 2021/5/13 0:18
 */
public class LongestValidParentheses32 {

    public int longestValidParentheses(String s) {
        if (s == null || s.length() <= 1) {
            return 0;
        }

        Deque<Integer> stack = new LinkedList();

        int res = 0;
        //初始化栈
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            }else {
                //弹出栈顶元素
                stack.pop();
                //如果栈里面已经没有元素了,则把当前位置压入栈内
                if (stack.isEmpty()) stack.push(i);
                else {
                    //找到符合括号的最大长度
                    res = Math.max(res, i - stack.peek());
                }
            }
        }
        return res;
    }

    public int longestValidParenthesesDp(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        char[] str = s.toCharArray();
        int res = 0;
        int[] dp = new int[str.length];
        for(int i = 0; i < str.length; i++){
            if(i > 0 && str[i] == ')'){
                if(str[i - 1] == '('){
                    dp[i] = i - 2 >= 0? dp[i - 2] + 2 : 2;
                    //前面一个字符的有效长度之前的字符为(
                }else if(i - dp[i - 1] - 1 >= 0 && str[i - dp[i - 1] - 1] == '('){
                    dp[i] = dp[i - 1] + 2 + (i - dp[i -1] - 2 >= 0 ? dp[i - dp[i -1] - 2] : 0);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
