package algorithm.leetcode.dynamic;

import java.util.HashMap;

/**
 * 956. 最高的广告牌
 * @author: xiongyayun
 * @date: 2021/9/8 11:39 下午
 */
public class TallestBillboard956 {

    public static void main(String[] args) {
        System.out.println(tallestBillboard(new int[]{1,2,3,6}));
    }

    public static int tallestBillboard(int[] rods) {
        HashMap<Integer, Integer> dp = new HashMap<>(), cur;
        dp.put(0, 0);// 空集 和 空集
        for (int rod : rods) {
            cur = new HashMap<>(dp); // 考虑x之前的集合差值状况拷贝下来
            cur.forEach((k, v) ->{
                //为0的没有必要走,因为没有任何影响
                if (rod != 0) {
                    dp.put(k + rod, Math.max(v, dp.getOrDefault(rod + k, 0)));
                    //取到当前差为rod -k 的绝对值的值(因为放的是key :差值  value: 比较小的那个数)
                    int abs = Math.abs(rod - k);
                    int diffXD = dp.getOrDefault(abs, 0);
                    if (rod >= k) {
                        dp.put(abs, Math.max(v + k , diffXD));
                    }else {
                        dp.put(abs, Math.max(v + rod, diffXD));
                    }
                }
            });

        }
        return dp.get(0);
    }
}
