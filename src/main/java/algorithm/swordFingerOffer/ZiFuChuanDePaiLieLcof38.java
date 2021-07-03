package algorithm.swordFingerOffer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author: xiongyayun
 * @date: 2021/6/23 12:03 上午
 */
public class ZiFuChuanDePaiLieLcof38 {

    private List<String> res = new ArrayList<>();
    char [] chars;
    public String[] permutation(String s) {
        if (s == null || s.length() == 0 ) return null;

        chars = s.toCharArray();
        //递归所有字符
        dfs(0);
        return res.toArray(new String[]{});
    }

    private void dfs(int index) {
        //长度相等
        if (index == chars.length) {
            res.add(new String(chars));
        }

        HashSet<Character> set = new HashSet<>();
        for (int i = index; i < chars.length; i++) {
            // 重复，因此剪枝
            if(set.contains(chars[i])) continue;
            //添加当前字符
            set.add(chars[i]);
            // 交换，将 chars[i] 固定在第 x 位
            swap(i, index);
            dfs(index + 1);
            //归位
            swap(i, index);

        }
    }

    void swap(int a, int b) {
        char tmp = chars[a];
        chars[a] = chars[b];
        chars[b] = tmp;
    }
}
