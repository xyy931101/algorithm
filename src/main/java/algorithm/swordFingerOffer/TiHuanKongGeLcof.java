package algorithm.swordFingerOffer;

/**
 * @author xiongyayun
 * @date 2021/5/9 22:57
 */
public class TiHuanKongGeLcof {

    public String replaceSpace(String s) {
        if (s == null || s.length() == 0) return s;

        char[] chars = s.toCharArray();

        int len = chars.length;
        for (char ch : chars) {
            if (ch == ' ') len = len + 2;
        }
        char[] newChars = new char[len];
        int newCharIndex = newChars.length - 1;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == ' ') {
                newChars[newCharIndex - 2] = '%';
                newChars[newCharIndex - 1] = '2';
                newChars[newCharIndex] = '0';
                newCharIndex -= 2;
            }else {
                newChars[newCharIndex] = chars[i];
            }
            newCharIndex--;
        }
        return new String(newChars);
    }
}
