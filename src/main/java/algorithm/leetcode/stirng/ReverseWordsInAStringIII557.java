package algorithm.leetcode.stirng;

/**
 * 557. 反转字符串中的单词 III
 * @author: xiongyayun
 * @date: 2022/1/30 13:54
 */
public class ReverseWordsInAStringIII557 {

    public static void main(String[] args) {
        reverseWords("Let's take LeetCode contest");
    }

    public static String reverseWords(String s) {
        int left = 0, right = 0;
        char[] str = s.toCharArray();
        while(right < str.length){
            if(str[right] == ' '){
                if(left == right){
                    left++;
                }else {
                    reverse(str, left, right - 1);
                    left = right;
                }
            }
            right++;
        }
        if(left != str.length - 1){
            reverse(str, left, str.length - 1);
        }
        return new String(str);
    }

    public static void reverse(char[] str, int left, int right) {
        while(left < right){
            char temp = str[left];
            str[left++] = str[right];
            str[right--] = temp;
        }
    }

}
