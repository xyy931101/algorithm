package algorithm.leetcode.array;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author: xiongyayun
 * @date: 2021/9/16 12:10 上午
 */
public class EvaluateReversePolishNotation150 {

    public static void main(String[] args) {
        evalRPN(new String[]{"4","13","5","/","+"});
    }

    public static int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();

        for (String str : tokens) {
            if (str.equals("+") || str.equals("-") || str.equals("/") || str.equals("*")) {
                compute(stack, str);
            }else {
                stack.push(Integer.valueOf(str));
            }
        }
        return stack.peek();
    }

    private static void compute(Deque<Integer> stack, String op) {
        int num2 = stack.poll();
        int num1 = stack.poll();
        Integer temp = 0;
        switch (op) {
            case "+":
                temp = num1 + num2;
                break;
            case "-":
                temp = num1 - num2;
                break;
            case "*":
                temp = num1 * num2;
                break;
            case "/":
                temp = num1 / num2;
                break;
        }
        stack.push(temp);
    }
}
