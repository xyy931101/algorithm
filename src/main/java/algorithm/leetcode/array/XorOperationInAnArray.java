package algorithm.leetcode.array;

/**
 * 1486. 数组异或操作
 * @author xiongyayun
 * @date 2021/5/7 7:59
 */
public class XorOperationInAnArray {

    public static void main(String[] args) {
        System.out.println(xorOperation(10, 5));
//        System.out.println(1 ^ 4);
    }
    public static int xorOperation(int n, int start) {
        int ans = 0, temp = start;

        for (int i = 0; i < n; i++) {
            ans = (start + i * 2) ^ ans;
        }
        return ans;
    }
}
