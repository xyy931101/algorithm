package algorithm.leetcode.stirng;

/**
 * 777. 在LR字符串中交换相邻字符
 * @author: xiongyayun
 * @date: 2022/10/2 20:13
 */
public class SwapAdjacentInLrString777 {

    public boolean canTransform(String start, String end) {
        int n = start.length(), i = 0, j = 0;
        while(i < n || j < n){
            while(i < n && start.charAt(i) == 'X') i++;
            while(j < n && end.charAt(j) == 'X') j++;
            if(i == n || j == n) return i == j;
            if(start.charAt(i) != end.charAt(j)) return false;
            //这里有个误区,因为是替换  所以是start "XL" -> "LX"
            if(start.charAt(i) == 'L' && i < j) return false;
            if(start.charAt(i) == 'R' && i > j) return false;
            i++; j++;
        }
        return i == j;
    }
}
