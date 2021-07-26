package algorithm.leetcode.array;

/**
 * 338. 比特位计数
 * @author: xiongyayun
 * @date: 2021/7/26 11:38 下午
 */
public class CountingBits338 {

    public static void main(String[] args) {
        System.out.println(countBits(5));
    }
    public static int[] countBits(int n) {

        int[] result = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            if ((i & 1) == 0){
                result[i] = result[i >> 1];
            }else {
                result[i] = result[i - 1] + 1;
            }
        }
        return result;
    }
}
