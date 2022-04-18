package algorithm.swordFingerOffer;

/**
 * 指 Offer 20. 表示数值的字符串
 * @author: xiongyayun
 * @date: 2022/4/7 10:45 下午
 */
public class BiaoShiShuZhiDeZifuchuanlcof_20 {
    public static void main(String[] args) {
        System.out.println(isNumber("3."));
    }

    public static boolean isNumber(String s) {
        s = s.trim();
        if (s.length() == 0) return false;
        if(s == null || s.length() == 0){
            return false;
        }
        //标记是否遇到相应情况
        boolean numSeen = false;
        boolean dotSeen = false;
        boolean eSeen = false;
        char[] str = s.toCharArray();
        for (int i = 0; i < str.length; i++) {
            if (str[i] >= '0' && str[i] <= '9') numSeen = true;
            else if(str[i] == '.'){
                if (dotSeen || eSeen) return false;
                dotSeen = true;
            }else if (str[i] == 'e' || str[i] == 'E'){
                if(eSeen || !numSeen){
                    return false;
                }
                eSeen = true;
                numSeen = false;
            }else if (str[i] == '-' || str[i] == '+'){
                if(i != 0 && str[i-1] != 'e' && str[i-1] != 'E'){
                    return false;
                }
            }else return false;

        }
        return numSeen;
    }
}
