package algorithm.leetcode.array;

import java.util.Arrays;

/**
 * 森林中，每个兔子都有颜色。其中一些兔子（可能是全部）告诉你还有多少其他的兔子和自己有相同的颜色。
 * 我们将这些回答放在 answers 数组里。
 *
 * 返回森林中兔子的最少数量。
 * @Author: Xiongyy
 * @Date: 2021/4/4 10:22
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class RabbitsInForest781 {

    public static void main(String[] args) {
        RabbitsInForest781 rabbitsInForest781 = new RabbitsInForest781();
        int i = rabbitsInForest781.numRabbits(new int[]{1, 1, 2});
        System.out.println(i);
    }


    public int numRabbits(int[] answers) {
        if (answers == null ||answers.length < 1){
            return 0;
        }
        //先排好序
        Arrays.sort(answers);
        int ans = 0;
        int pre = answers[0];
        int sameCount = 1;
        for (int i = 1; i < answers.length; i++) {
            if (answers[i] != pre) {
                //向上取整
                ans += (sameCount + pre)/(pre + 1) * (pre + 1);
                pre = answers[i];
                sameCount = 1;
            }else {
                sameCount++;
            }
        }
        return ans + (sameCount + pre)/(pre + 1) * (pre + 1);
    }

}
