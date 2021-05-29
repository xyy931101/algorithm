package algorithm.leetcode.array;

/**
 * 12. 整数转罗马数字
 * @author xiongyayun
 * @date 2021/5/14 8:12
 */
public class IntegerToRoman12 {

    public static void main(String[] args) {
        System.out.println(intToRoman(388));
    }


    public static String intToRoman(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};


        StringBuilder builder = new StringBuilder();
        int index = 0;
        while (index < 13) {
            // 特别注意：这里是等号
            while (num >= nums[index]) {
                builder.append(romans[index]);
                num -= nums[index];
            }
            index++;
        }

        return builder.toString();
    }
}
