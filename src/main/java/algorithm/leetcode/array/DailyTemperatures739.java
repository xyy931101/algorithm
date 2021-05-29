package algorithm.leetcode.array;

import com.alibaba.fastjson.JSONObject;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 739. 每日温度
 * @author xiongyayun
 * @date 2021/5/15 23:07
 */
public class DailyTemperatures739 {

    public static void main(String[] args) {
        System.out.println(JSONObject.toJSONString(dailyTemperatures(new int[] {73,74,75,71,69,72,76,73})));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) return temperatures;
        int len = temperatures.length;
        int[] res = new int[len];
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(0);
        int resIndex = 0;
        for (int i = 1; i < len; i++) {
            //如果当前元素大于栈顶元素
            while (!stack.isEmpty()&& temperatures [i] > temperatures[stack.peek()]) {
                Integer index = stack.pop();
                res[index] = i - index;
            }
            stack.push(i);
        }
        return res;
    }
}
