package algorithm.leetcode.array;

/**
 *
 * 1734. 解码异或后的排列
 * @author xiongyayun
 * @date 2021/5/11 8:07
 */
public class DecodeXoredPermutation1734 {

    public static void main(String[] args) {
        int[] arr = new int[] {2,4,1,5,3, 4};
        int allXor = 0;
        for (int i = 1; i <= arr.length; i++) {
            allXor ^= i;
        }

        int a = 0;
        for (int i = 0; i < arr.length; i++) {
            a ^= arr[i];
        }

        System.out.println(allXor);
        System.out.println(a);
    }


    public int[] decode(int[] encoded) {
        int length = encoded.length + 1;
        int allXor = 0;
        //把1到n中间的所有数字都异或一遍
        //因为条件给定了是前n个顺序的数字,也就是1~n
        for (int i = 1; i <= length; i++) {
            allXor ^= i;
        }

        int even = 0;
        //数组encoded中第偶数个元素都异或一遍
        for (int i = 1; i < length - 1; i += 2) {
            even ^= encoded[i];
        }

        int[] res = new int[length];
        //求出第一个值，后面就简单了
        res[0] = allXor ^ even;
        for (int i = 0; i < length - 1; i++) {
            res[i + 1] = res[i] ^ encoded[i];
        }
        return res;
    }
}
