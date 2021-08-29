package algorithm.leetcode.dynamic;

/**
 * 940. 不同的子序列 II
 * @author: xiongyayun
 * @date: 2021/8/29 10:26 下午
 */
public class DistinctSubsequencesII940 {

    public int distinctSubseqII(String s) {
        if (s == null || s.length() ==0) return 0;


        int m = 1000000007;
        char[] str = s.toCharArray();
        int[] count = new int[26];
        int all = 1; // 算空集
        for (int i = 0; i < str.length; i++) {
            //前面以str[i]为结尾的数量
            int add = (all - count[str[i] - 'a'] + m) % m;
            count[str[i] - 'a'] = all;
            all = (add + all)  % m;
        }

        return all - 1;
    }
}
