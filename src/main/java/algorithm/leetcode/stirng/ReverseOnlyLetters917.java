package algorithm.leetcode.stirng;

/**
 * 917. 仅仅反转字母
 * @author: xiongyayun
 * @date: 2022/1/30 14:00
 */
public class ReverseOnlyLetters917 {

    public String reverseOnlyLetters(String s) {
        char[] str = s.toCharArray();
        int left = 0, right = str.length - 1;
        while(left < right){
            while (left < right && !Character.isLetter(str[left])){
                left++;
            }
            while (left < right && !Character.isLetter(str[right])){
                right--;
            }
            char temp = str[left];
            str[left++] = str[right];
            str[right--] = temp;
        }
        return new String(str);
    }
}
