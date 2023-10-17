package algorithm.leetcode.integer;

/**
 * @author: xiongyayun
 * @date: 2023/10/17 22:55
 */
public class SumOfMultiples2652 {


    public static void main(String[] args) {
        System.out.println(sumOfMultiples(15));
    }

    public static int sumOfMultiples(int n) {
        int res = 0;
        for(int i = 1; i <= n; i++){
            if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0) {
                res += i;
            }
        }
        return res;
    }
}
