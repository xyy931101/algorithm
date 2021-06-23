package algorithm.leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 394. 字符串解码
 * @author: xiongyayun
 * @date: 2021/6/23 11:02 下午
 */
public class DecodeString394 {

    public static void main(String[] args) {
        System.out.println(decodeString("100[leetcode]"));
    }

    public static String decodeString(String s) {
        if(s == null || s.length() == 0) return null;

        StringBuilder res = new StringBuilder();
        char[] chars = s.toCharArray();
        int multi = 0;

        LinkedList<Integer> stack_mulit = new LinkedList<>();
        LinkedList<String> stack_res = new LinkedList<>();
        for(char ch : chars) {
            //处理倍数
            if(ch >= '1' && ch <= '9') {
                //处理十进制位
                multi = multi * 10 + Integer.parseInt(ch + "");
            }else if (ch == '[') {
                //处理括号开始
                stack_mulit.addLast(multi);
                stack_res.addLast(res.toString());
                multi = 0;
                res = new StringBuilder();
            }else if(ch == ']') {
                StringBuilder temp = new StringBuilder();
                //获取到当前的倍数
                int cur_multi = stack_mulit.removeLast();
                for(int i = 0; i < cur_multi; i++) {
                    temp.append(res);
                }
                //处理单个括号里面的字符串
                res = new StringBuilder(stack_res.removeLast() + temp);
            }else{
                //处理正常字符
                res.append(ch);
            }
        }
        return res.toString();
    }
}
