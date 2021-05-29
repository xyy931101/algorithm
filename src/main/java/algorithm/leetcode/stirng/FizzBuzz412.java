package algorithm.leetcode.stirng;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Xiongyy
 * @Date: 2021/4/10 15:45
 * .............................................
 * 佛祖保佑             永无BUG
 */
public class FizzBuzz412 {

    public List<String> fizzBuzz(int n) {
        //处理边界值
        if (n < 1) {
            return new ArrayList<>();
        }


        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            //这里不要用String, 会比较耗时
            StringBuffer s = new StringBuffer();
            if(i % 3 == 0){
                s.append("Fizz");
            }
            if (i % 5 == 0) {
                s.append("Buzz");
            }
            if (s.length() == 0) {
                s.append(i);
            }
            res.add(s.toString());
        }
        return res;
    }
}
