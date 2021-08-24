package algorithm.leetcode.stack;

import java.util.LinkedList;

/**
 * 224. 基本计算器
 * @author: xiongyayun
 * @date: 2021/8/23 8:19
 */
public class BasicCalculator224 {

    public static void main(String[] args) {
        System.out.println(calculate("1 + 1"));
    }

    public static int calculate(String s) {
        if (s == null || s.length() == 0) return 0;

        return process(s.toCharArray(), 0)[0];
    }

    private static int[] process(char[] chars, int index) {
        int cur = 0;
        LinkedList<String> que = new LinkedList<String>();
        while (index < chars.length && chars[index] != ')') {
            if (chars[index] >= '0' && chars[index] <= '9') {
                cur = cur * 10 + chars[index++] - '0';
            }else if (chars[index] == ' ') {//空字符串直接跳过
                index++;
            }else if (chars[index] == '(') {
                int[] bra = process(chars, index + 1);
                cur = bra[0];
                index = bra[1] + 1;
            }else { //运算符
                que.add(String.valueOf(cur));
                que.add(String.valueOf(chars[index++]));
                cur = 0;
            }
        }
        que.add(String.valueOf(cur));
        return new int[]{getNum(que), index};
    }
    public static int getNum(LinkedList<String> que) {
        int res = 0;
        boolean add = true;
        while (!que.isEmpty()){
            String cur = que.pollFirst();
            if (cur.equals("+")) {
                add = true;
            } else if (cur.equals("-")) {
                add = false;
            } else {
                if (add) res = res + Integer.valueOf(cur);
                else res = res - Integer.valueOf(cur);
            }
        }
        return res;
    }

}
