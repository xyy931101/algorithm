package algorithm.swordFingerOffer;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * @Author: Xiongyy
 * @Date: 2021/2/14 9:49
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class ReplaceSpace_5 {
    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println(replaceSpace(s));
    }

    public static String replaceSpace(String s) {
        int length = s.length();
        char[] array = new char[length * 3];
        int size = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            } else {
                array[size++] = c;
            }
        }
        String newStr = new String(array, 0, size);
        return newStr;
    }

    public static String replaceSpace2(String s) {
        StringBuffer buffer = new StringBuffer();
        for (char ch : s.toCharArray()) {
            if (ch == ' '){
                buffer.append("%20");
            }else {
                buffer.append(ch);
            }
        }
        return buffer.toString();
    }
}
