package algorithm.leetcode.stirng;

/**
 * 1768. 交替合并字符串
 * @author: xiongyayun
 * @date: 2022/10/23 14:09
 */
public class MergeStringsAlternately1768 {

    public String mergeAlternately(String word1, String word2) {
        int index1 = 0, index2 = 0;
        StringBuffer sb = new StringBuffer();
        while(index1 < word1.length() && index2 < word2.length()){
            sb.append(word1.charAt(index1++));
            sb.append(word2.charAt(index2++));
        }
        if(index1 >= word1.length()){
            sb.append(word2.substring(index2));
        }else {
            sb.append(word1.substring(index1));
        }
        return sb.toString();
    }
}
