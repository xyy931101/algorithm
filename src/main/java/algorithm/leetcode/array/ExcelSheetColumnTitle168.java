package algorithm.leetcode.array;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: xiongyayun
 * @date: 2021/6/29 11:44 下午
 */
public class ExcelSheetColumnTitle168 {

    public String convertToTitle(int columnNumber) {
        if (columnNumber <= 0) {
            return null;
        }

        StringBuilder sb = new StringBuilder();

        while(columnNumber != 0){
            //由于Excel是从1开始的,所以每轮开始前需要减一
            columnNumber --;
            sb.append((char) (columnNumber % 26 + 'A'));
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }
}
