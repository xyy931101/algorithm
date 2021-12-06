package algorithm.leetcode.stirng;

/**
 * 1816. 截断句子
 * @author: xiongyayun
 * @date: 2021/12/6 8:33
 */
public class TruncateSentence1816 {

    public String truncateSentence(String s, int k) {
        if (k <= 0) return null;
        int count  = 0;
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                count++;
                if (count == k) break;
            }
            buffer.append(s.charAt(i));
        }
        return buffer.toString();
    }

}
